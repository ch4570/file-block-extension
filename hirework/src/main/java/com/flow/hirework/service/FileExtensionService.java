package com.flow.hirework.service;

import com.flow.hirework.domain.CustomExtension;
import com.flow.hirework.domain.DefaultExtension;
import com.flow.hirework.dto.CustomExtensionDto;
import com.flow.hirework.exception.CustomException;
import static com.flow.hirework.exception.ErrorCode.*;
import com.flow.hirework.repository.DefaultExtensionRepository;
import com.flow.hirework.repository.CustomExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class FileExtensionService {

    private final CustomExtensionRepository customExtensionRepository;
    private final DefaultExtensionRepository defaultExtensionRepository;


    // 새로운 커스텀 확장자를 저장
    public void addCustomExtension(CustomExtensionDto customExtensionDto) {
        boolean isDuplicatedDefaultExtension = customExtensionRepository.existsByName(customExtensionDto.getName());
        boolean isDuplicatedCustomExtension = defaultExtensionRepository.existsByName(customExtensionDto.getName());
        long customExtensionCount = customExtensionRepository.count();

        if (isDuplicatedCustomExtension || isDuplicatedDefaultExtension) {
            throw new CustomException(IS_DUPLICATE_BAD_REQUEST);
        }

        if (customExtensionCount >= 200) {
            throw new CustomException(NOT_LEFT_SPACE_TO_SAVE_EXTENSION_BAD_REQUEST);
        }

        customExtensionRepository.save(customExtensionDto.toEntity());
    }

    // 커스텀 확장자 삭제
    public void removeCustomExtension(String name) {
        CustomExtension extensionDto = customExtensionRepository.findByName(name)
                .orElseThrow(() -> new CustomException(IS_NOT_PRESENT_EXTENSION_BAD_REQUEST));

        customExtensionRepository.delete(extensionDto);
    }

    // 디폴트 확장자의 체크 여부를 변경
    public void modifyDefaultExtension(String name) {
        DefaultExtension defaultExtension = defaultExtensionRepository.findByName(name)
                .orElseThrow(() -> new CustomException(IS_NOT_PRESENT_EXTENSION_BAD_REQUEST));

        // 디폴트 확장자가 체크 되어 있다면 -> 체크되지 않은 상태로 변경
        if (defaultExtension.isChecked()) {
            defaultExtensionRepository.updateDefaultExtensionUnchecked(name);
            return;
        }

        // 디폴트 확장자가 체크 되어 있지 않다면 -> 체크된 상태로 변
        defaultExtensionRepository.updateDefaultExtensionChecked(name);
    }

    @Transactional(readOnly = true)
    // 파일의 확장자가 등록가능한 확장자인지 확인
    public boolean isAllowedExtension(MultipartFile multipartFile) {
        String extension = getExtension(multipartFile);

        // 커스텀 확장자와 기본 확장자에 존재하지 않아야 등록이 가능한 파일확장자이다.
        boolean isAllowedDefaultExtension = defaultExtensionRepository.existsByName(extension);
        boolean isAllowedCustomExtension = customExtensionRepository.existsByName(extension);

        return !isAllowedDefaultExtension && !isAllowedCustomExtension;
    }

    public String getExtension(MultipartFile multipartFile) {
        return multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);
    }
}

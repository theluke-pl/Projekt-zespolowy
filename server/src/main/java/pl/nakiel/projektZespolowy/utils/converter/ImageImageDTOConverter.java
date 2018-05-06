package pl.nakiel.projektZespolowy.utils.converter;

import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.events.Image;
import pl.nakiel.projektZespolowy.resources.dto.common.ImageDTO;
import pl.nakiel.projektZespolowy.service.FileService;
import java.util.Base64;

@Service
public class ImageImageDTOConverter {
    public ImageDTO toImageDTO(Image image){
        ImageDTO imageDTO = new ImageDTO();
        //nazwa pliku
        String url = image.getUrl();
        imageDTO.setFileName(url.substring(url.lastIndexOf('\\') + 1));
        //zawartość pliku w base64
        FileService fileService = new FileService();
        imageDTO.setFileContent(fileService.loadFileB64(url));
        imageDTO.setId(image.getId());

        return imageDTO;
    }
}

package demo.util;


import demo.model.InventarioDto;
import demo.model.InventarioVO;

public class InventarioMapper {

    public static InventarioVO dtoToEntity(InventarioDto dto) {
        return InventarioVO.builder()
                .stock(dto.getStock())
                .ubicaciones(dto.getUbicaciones())
                .build();
    }

    public static InventarioDto entityToDto(InventarioVO entity) {
        return InventarioDto.builder()
                .stock(entity.getStock())
                .ubicaciones(entity.getUbicaciones())
                .build();
    }
}

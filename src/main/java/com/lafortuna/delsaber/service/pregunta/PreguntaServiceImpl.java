/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.pregunta;

import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.Pregunta;
import com.lafortuna.delsaber.model.PreguntaMensaje;
import com.lafortuna.delsaber.model.Respuesta;
import com.lafortuna.delsaber.repository.PreguntaMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cliente
 */
@Service
public class PreguntaServiceImpl extends GenericService implements PreguntaService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private PreguntaMapper preguntaMapper;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cargaPreguntas(MultipartFile file) {
        int countFila = 0;
        try {
            XSSFWorkbook excel = new XSSFWorkbook(file.getInputStream());
            XSSFSheet hoja = excel.getSheetAt(0);
            Iterator filas = hoja.iterator();
            while(filas.hasNext()) {                
                countFila++;
                XSSFRow fila = (XSSFRow) filas.next();
                if(fila.getCell(0).getStringCellValue().isEmpty()) {
                    break;
                }
                
                Pregunta p = new Pregunta();
                p.setIdDificultad(getDificulta(fila.getCell(3).getStringCellValue()));
                p.setDescripcion(fila.getCell(0).getStringCellValue());
                p.setClase(fila.getCell(1).getStringCellValue());
                p.setRuta(fila.getCell(2).getStringCellValue());
                this.preguntaMapper.guardarPregunta(p);
                
                Respuesta r1 = new Respuesta();
                r1.setIdPregunta(p.getIdPregunta());
                r1.setDescripcion(getDescripcionRespuesta(fila.getCell(4)));
                r1.setOrden(1);
                r1.setCorrecta(Boolean.TRUE);
                
                Respuesta r2 = new Respuesta();
                r2.setIdPregunta(p.getIdPregunta());
                r2.setDescripcion(getDescripcionRespuesta(fila.getCell(6)));
                r2.setOrden(2);
                r2.setCorrecta(Boolean.FALSE);
                
                Respuesta r3 = new Respuesta();
                r3.setIdPregunta(p.getIdPregunta());
                r3.setDescripcion(getDescripcionRespuesta(fila.getCell(8)));
                r3.setOrden(3);
                r3.setCorrecta(Boolean.FALSE);               
                
                this.preguntaMapper.guardarRespuesta(r1);
                this.preguntaMapper.guardarRespuesta(r2);
                this.preguntaMapper.guardarRespuesta(r3); 
            }
        } catch (DataAccessException | IOException e) {
            throw new InternalServerException("Error al leer el excel fila: " + (countFila-1) + " error: " + e);
        }
    }
    
    public int getDificulta(String dificultad) {
        switch(dificultad) {
            case "A": return 1;
            case "B": return 2;
            case "C": return 3;
        }
        return 1;
    }
    
    public String getDescripcionRespuesta(XSSFCell cell) {        
        if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {            
            return Double.toString(cell.getNumericCellValue());
        } else {        
            return cell.getStringCellValue();
        }        
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreguntaMensaje> getPreguntaMensajeByPatrocinador(Integer idPatrocinador) {
        List<PreguntaMensaje> preguntaMensajeList = this.preguntaMapper.getPreguntaMensajeByPatrocinador(idPatrocinador);
        if(listaValida(preguntaMensajeList)) {return preguntaMensajeList;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
}

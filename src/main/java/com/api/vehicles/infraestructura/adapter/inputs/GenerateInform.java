package com.api.vehicles.infraestructura.adapter.inputs;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.GenerateInformPort;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConsultEntity;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConsultEntityRepository;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@Service
public class GenerateInform implements GenerateInformPort {
	@Autowired
	ConsultEntityRepository consultRepo;
	
	@Override
	public com.api.vehicles.domain.GenerateInform generateInform(com.api.vehicles.domain.GenerateInform co) {
		Document doc= new Document(PageSize.A4);
		Font fsub= new Font(FontFactory.getFont("",12,Font.NORMAL,new BaseColor(79, 129, 188)));
		Font fblue= new Font(FontFactory.getFont(FontFactory.TIMES,12,Font.NORMAL,new BaseColor(79, 129, 188)));
        Font f12n= new Font(FontFactory.getFont(FontFactory.TIMES,12,Font.NORMAL,BaseColor.BLACK));
        Font f13n= new Font(FontFactory.getFont("",13,Font.NORMAL,new BaseColor(0, 51, 102)));
        try {
        	
        	ConsultEntity ce= consultRepo.findById(co.getId()).get();
            String inform=co.getId()+"-"+co.getNit()+"-inform.pdf";
            PdfWriter w=PdfWriter.getInstance(doc, new FileOutputStream(co.getId()+"-"+co.getNit()+"-inform.pdf"));
            doc.open();
            //titulo
            Paragraph titulo= new Paragraph("\n\nReporte Detallado del Vehículo\n\n",f13n);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(5f);
            doc.add(titulo);
            //adorno cuadro
            PdfPCell cuadroBlue=new PdfPCell();
            cuadroBlue.setFixedHeight(40f);
            cuadroBlue.setBackgroundColor(new BaseColor(0, 51, 102));
            PdfPTable cuadro=new PdfPTable(1);
            cuadro.addCell(cuadroBlue);
            cuadro.setWidthPercentage(100);
            doc.add(cuadro);
            
            Paragraph titulo2= new Paragraph("\nInformación del Propietario (VENDEDOR)\n",fsub);
            titulo2.setSpacingAfter(5f);
            doc.add(titulo2);
            
            PdfPCell cell= new PdfPCell();
            
            PdfPTable t1=new PdfPTable(2);
            cell.setPhrase(new Phrase("Nombre del propietario:",f12n));
            t1.addCell(cell);
            cell.setPhrase(new Phrase(co.getOwner(),f12n));
            t1.addCell(cell);
            
            cell.setPhrase(new Phrase("NIT:",f12n));
            t1.addCell(cell);
            cell.setPhrase(new Phrase(co.getNit(),f12n));
            t1.addCell(cell);
            
            cell.setPhrase(new Phrase("Situación de Incumplimientos:",f12n));
            t1.addCell(cell);
            cell.setPhrase(new Phrase(co.getSituacionOwner(),f12n));
            t1.addCell(cell);
            
            t1.setWidthPercentage(100);
            doc.add(t1);
            
            Paragraph titulo3= new Paragraph("\nESTATUS NIT (VENDEDOR)\n",fsub);
            titulo3.setSpacingAfter(5f);
            doc.add(titulo3);
            
            PdfPTable t2=new PdfPTable(2);
            cell.setPhrase(new Phrase("Puede realizar traspaso electrónico:",f12n));
            t2.addCell(cell);
            cell.setPhrase(new Phrase(co.getTraspaso(),f12n));
            t2.addCell(cell);
            
            cell.setPhrase(new Phrase("NIT:",f12n));
            t2.addCell(cell);
            cell.setPhrase(new Phrase(co.getNitSeller(),f12n));
            t2.addCell(cell);
            
            cell.setPhrase(new Phrase("Datos Actualizados:",f12n));
            t2.addCell(cell);
            cell.setPhrase(new Phrase(co.getDataActually(),f12n));
            t2.addCell(cell);
            
            t2.setWidthPercentage(100);
            doc.add(t2);
            
            
            Paragraph titulo4= new Paragraph("\nCaracterísticas del Vehículo\n",fsub);
            titulo4.setSpacingAfter(5f);
            doc.add(titulo4);
            
            PdfPTable t3=new PdfPTable(2);
            cell.setPhrase(new Phrase("Placa:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getPlacaVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Tipo:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getTypeVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Uso:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getUseVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Marca:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getMarcaVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Línea:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getLineVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Modelo (año de fabricación):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getYearVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Puertas (cantidad):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getAmountDoorVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Asientos (cantidad):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getSeatVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Tonelaje de carga (en toneladas):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getCargaVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Ejes (cantidad):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getEjesVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Cilindros (cantidad):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getCilindrosVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Combustible:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getConbustibleVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("VIN (Número de Identificación Vehicular):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getVinVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Serie (número):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getSerieVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Motor (número):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getMotorVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Color:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getColorVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Centímetros Cúbicos del Motor (cm3):",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getCilindrajeVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("DATOS IMPORTANTES",fblue));/////////////////////////////////////////////////
            t3.addCell(cell);
            cell.setPhrase(new Phrase("",f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Código del vehículo:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getCodeVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Número de tarjeta de circulación vigente:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getNumCardVehicle(),f12n));
            t3.addCell(cell);
            
            cell.setPhrase(new Phrase("Número de certificado de propiedad vigente:",f12n));
            t3.addCell(cell);
            cell.setPhrase(new Phrase(co.getNumCertVehicle(),f12n));
            t3.addCell(cell);
            t3.setWidthPercentage(100);
            doc.add(t3);
            
            doc.newPage();
            Paragraph titulo5= new Paragraph("\nSituación del Vehículo\n",fsub);
            titulo5.setSpacingAfter(5f);
            doc.add(titulo5);
            
            PdfPTable t4=new PdfPTable(2);
            cell.setPhrase(new Phrase("Estado:",f12n));
            t4.addCell(cell);
            cell.setPhrase(new Phrase(co.getStatusVehicle(),f12n));
            t4.addCell(cell);
            
            cell.setPhrase(new Phrase("Motivo:",f12n));
            t4.addCell(cell);
            cell.setPhrase(new Phrase(co.getMotivoVehicle(),f12n));
            t4.addCell(cell);
            
            cell.setPhrase(new Phrase("Multas de tránsito:",f12n));
            t4.addCell(cell);
            cell.setPhrase(new Phrase(co.getMultasVehicle(),f12n));
            t4.addCell(cell);
            
            cell.setPhrase(new Phrase("Impuesto de circulación:",f12n));
            t4.addCell(cell);
            cell.setPhrase(new Phrase(co.getImpuestoCirculacionVehicle(),f12n));
            t4.addCell(cell);
            t4.setWidthPercentage(100);
            doc.add(t4);
            
            
            Paragraph titulo6= new Paragraph("\nDeterminación del vehículo\n",fsub);
            titulo6.setSpacingAfter(5f);
            doc.add(titulo6);
            
            PdfPTable t5=new PdfPTable(2);
            cell.setPhrase(new Phrase("Impuesto:",f12n));
            t5.addCell(cell);
            cell.setPhrase(new Phrase(co.getImpuestoVehicle(),f12n));
            t5.addCell(cell);
            
            cell.setPhrase(new Phrase("Monto:",f12n));
            t5.addCell(cell);
            cell.setPhrase(new Phrase(co.getMontoVehicle(),f12n));
            t5.addCell(cell);
            
            cell.setPhrase(new Phrase("Puede realizar Traspaso electrónico:",f12n));
            t5.addCell(cell);
            cell.setPhrase(new Phrase(co.getPuedeTraspasoVehicle(),f12n));
            t5.addCell(cell);
            
            cell.setPhrase(new Phrase("Nota:",f12n));
            t5.addCell(cell);
            cell.setPhrase(new Phrase(co.getNotaVehicle(),f12n));
            t5.addCell(cell);
            t5.setWidthPercentage(100);
            doc.add(t5);
            
            
            Paragraph titulo7= new Paragraph("\nMultas de Transito\n",fsub);
            titulo7.setSpacingAfter(5f);
            doc.add(titulo7);
            
            PdfPTable t6=new PdfPTable(2);
            cell.setPhrase(new Phrase("Municipalidad de Guatemala:",f12n));
            t6.addCell(cell);
            cell.setPhrase(new Phrase(co.getGuatemalaMulta(),f12n));
            t6.addCell(cell);
            
            cell.setPhrase(new Phrase("Municipalidad de Santa Catarina Pinula:",f12n));
            t6.addCell(cell);
            cell.setPhrase(new Phrase(co.getSantacatalinaMulta(),f12n));
            t6.addCell(cell);

            cell.setPhrase(new Phrase("Municipalidad de Mixco:",f12n));
            t6.addCell(cell);
            cell.setPhrase(new Phrase(co.getMixcoMulta(),f12n));
            t6.addCell(cell);

            cell.setPhrase(new Phrase("Municipalidad de Villa Nueva:",f12n));
            t6.addCell(cell);
            cell.setPhrase(new Phrase(co.getVillanuevaMulta(),f12n));
            t6.addCell(cell);

            cell.setPhrase(new Phrase("Municipalidad de San Miguel Petapa:",f12n));
            t6.addCell(cell);
            cell.setPhrase(new Phrase(co.getSanmiguelMulta(),f12n));
            t6.addCell(cell);
            t6.setWidthPercentage(100);
            doc.add(t6);
            
            Paragraph titulo8= new Paragraph("\nTransito PNC\n",fsub);
            titulo8.setSpacingAfter(5f);
            doc.add(titulo8);
            
            PdfPTable t7=new PdfPTable(2);
            cell.setPhrase(new Phrase("PNC",f12n));
            t7.addCell(cell);
            cell.setPhrase(new Phrase(co.getPnc(),f12n));
            t7.addCell(cell);
            t7.setWidthPercentage(100);
            doc.add(t7);
            
            Paragraph titulo9= new Paragraph("\nInformación Importante\n",fsub);
            titulo9.setSpacingAfter(5f);
            doc.add(titulo9);
            
            PdfPTable t8=new PdfPTable(2);
            cell.setPhrase(new Phrase("garantía Mobiliaria",f12n));
            t8.addCell(cell);
            cell.setPhrase(new Phrase(co.getGarantia(),f12n));
            t8.addCell(cell);
            t8.setWidthPercentage(100);
            doc.add(t8);
            
            doc.close();
            
            ce.setInform(inform);
            ce.setStatus("AVAILABLE");
            
            consultRepo.save(ce);
            return co;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}
}

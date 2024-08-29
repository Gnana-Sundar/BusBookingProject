package com.PvrTheater.PVRTheater.Files;

import com.PvrTheater.PVRTheater.Models.BookingResponse;
import com.PvrTheater.PVRTheater.Repository.BookingRepository;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

@Service
public class CreatePdf {
	@Autowired
	BookingRepository bookingRepository;
	public String createPdf(int booking_id) {

	    Optional<BookingResponse> bookingOpt = bookingRepository.findById(booking_id-1);

	    if (!bookingOpt.isPresent()) {
	        return "Booking not found";
	    }

	    BookingResponse bookingResponse = bookingOpt.get();
	    
	    try (PDDocument document = new PDDocument()) {
	        PDPage page = new PDPage();
	        document.addPage(page);
	        
	        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
	            contentStream.setFont(PDType1Font.HELVETICA, 12);
	            contentStream.beginText();
	            contentStream.setLeading(14.5f);
	            contentStream.newLineAtOffset(50, 750);
	            
	            contentStream.showText("Booking Id: " + bookingResponse.getBooking_id());
	            contentStream.newLine();
	            contentStream.showText("Booking Date: " + bookingResponse.getDate());
	            contentStream.newLine();
				contentStream.showText("Movie Id: " + bookingResponse.getMovie_id());
				contentStream.newLine();
	            contentStream.showText("Show Time: " + bookingResponse.getShowTime());
	            contentStream.newLine();
	            contentStream.showText("Total Tickets: " + bookingResponse.getQty());
	            contentStream.newLine();
	            contentStream.showText("Total Amount: " + bookingResponse.getAmount());
	            
	            contentStream.endText();
	        }
	        
	        document.save("D:\\filewriter\\pvrticket.pdf");
	        
	    } catch (IOException e) {
	        System.out.println(e);
	        return "Error creating PDF file";
	    }
	    
	    return "PDF file created successfully";
	}
	
	public String createTxtFile(int booking_id) {
		Optional<BookingResponse>bookingOpt = bookingRepository.findById(booking_id-1);

		if (!bookingOpt.isPresent()) {
			return "Booking not found";
		}
		BookingResponse bookingResponse = bookingOpt.get();
	
	   try {
            FileWriter fileWriter = new FileWriter("D:\\filewriter/pvrticket.txt");

            fileWriter.write("Booking Id : "+bookingResponse.getBooking_id()+"\nBooking Date : "+bookingResponse.getDate()
					+"\nMovie Id : "+bookingResponse.getMovie_id()+"\nShow Time : "+bookingResponse.getShowTime()+"\nTotal Tickets : "+bookingResponse.getQty()
					+"\nTotal Amount : "+bookingResponse.getAmount());

            fileWriter.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
	   
		
		return "File Create Successfully";
	}
}

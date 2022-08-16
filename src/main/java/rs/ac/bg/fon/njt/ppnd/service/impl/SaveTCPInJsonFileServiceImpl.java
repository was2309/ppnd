package rs.ac.bg.fon.njt.ppnd.service.impl;

import java.io.FileWriter;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.ppnd.dto.TeachingCoveragePlanDTO;

@Component
public class SaveTCPInJsonFileServiceImpl {

    void saveTCPToFile(TeachingCoveragePlanDTO tcpDTO){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(PrintWriter pw=new PrintWriter(new FileWriter("tcp"+ tcpDTO.getModuleSubject().getSubject().getName()+" for " + tcpDTO.getYear().getStudyYear() +".json"))) {
            pw.write(gson.toJson(tcpDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

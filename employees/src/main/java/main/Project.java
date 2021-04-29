package main;

import lombok.Getter;
import org.ocpsoft.prettytime.nlp.PrettyTimeParser;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Getter
public class Project {

    private String projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    Project(String projectId, String dateFrom, String dateTo){
        this.projectId = projectId;
        this.dateFrom = convertStringToLocalDate(dateFrom.trim());
        setDateTo(dateTo);
    }

    private LocalDate convertStringToLocalDate(String date) {
        List<Date> parse = new PrettyTimeParser().parse(date);
        return parse
                .get(0)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public void setDateTo(String dateTo) {
        if(dateTo.trim().equalsIgnoreCase("NULL")){
            this.dateTo = LocalDate.now();
        } else {
            this.dateTo = convertStringToLocalDate(dateTo.trim());
        }
    }
}

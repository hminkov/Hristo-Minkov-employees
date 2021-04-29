package main;

import exceptions.NotFoundException;
import java.io.File;

public class Demo{
    public static void main(String[] args) throws NotFoundException {
        File file = new File("employees.csv");
        Company company = new Company(file);
        company.printTeamWhoWorkedLongestTogether();
        company.printAllTeamsSorted();
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path of the file you would like to test.\n");
        String filepath = scanner.next();
        List<String> csvString = CSVtoString(filepath);
        List<Enrollee> enrollees = parseCSVString(csvString);
        HashMap<String, List<Enrollee>> companies = generateCompanies(enrollees);
        HashMap<String, List<Enrollee>> finalCompanies = filterDuplicateUsers(companies);
        sortByName(finalCompanies);
        writeToFiles(finalCompanies);


    }

    public static void writeToFiles(HashMap<String, List<Enrollee>> companies) {
        for(Map.Entry<String, List<Enrollee>> company : companies.entrySet()) {
            String companyName = buildFileName(company.getKey());
            List<Enrollee> enrollees = company.getValue();
            try {
                File newCompany = new File(companyName);
                FileWriter writer = new FileWriter(companyName);
                for (Enrollee enrollee : enrollees) {
                    writer.write(enrollee.writeToRows() + "\n");
                }
                writer.close();
            }
            catch(IOException e) {
                System.out.println("An IOException occurred");
                e.printStackTrace();
            }


        }
    }

    public static String buildFileName(String companyName) {
        return "src/" + companyName + ".csv";
    }

    public static void sortByName(HashMap<String, List<Enrollee>> companies) {
        for(List<Enrollee> enrolleeList : companies.values()) {
            enrolleeList.sort((e1, e2) ->  {
                int res =  e1.getLastName().compareToIgnoreCase(e2.getLastName());
                if (res != 0) {
                    return res;
                }
                return e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
                }
            );

        }
    }

    public static HashMap<String, List<Enrollee>> filterDuplicateUsers(HashMap<String, List<Enrollee>> companies) {
        HashMap<String, List<Enrollee>> finalCompanies = new HashMap<String, List<Enrollee>>();
        for(String companyName : companies.keySet()) {
            finalCompanies.put(companyName, new ArrayList<Enrollee>());
        }

        for(Map.Entry<String, List<Enrollee>> entry : companies.entrySet()) {
            String companyName = entry.getKey();
            List<Enrollee> enrollees = entry.getValue();
            HashMap<String, Enrollee> userIdVersionMap = new HashMap<String, Enrollee>();
            for(Enrollee enrollee : enrollees) {
                if(userIdVersionMap.containsKey(enrollee.userId)) {
                    if(userIdVersionMap.get(enrollee.userId).version < enrollee.version) {
                        userIdVersionMap.put(enrollee.userId, enrollee);
                    }
                }
                else {
                    userIdVersionMap.put(enrollee.userId, enrollee);
                }
            }
            for(Enrollee enrollee : userIdVersionMap.values()) {
                finalCompanies.get(companyName).add(enrollee);
            }
        }
        return finalCompanies;
    }

    public static HashMap<String, List<Enrollee>> generateCompanies(List<Enrollee> enrollees) {
        HashMap<String, List<Enrollee>> companies = new HashMap<String,List<Enrollee>>();
        for(Enrollee enrollee : enrollees) {
            String companyName = enrollee.getInsuranceCompany();
            if(companies.containsKey(companyName)) {
                companies.get(companyName).add(enrollee);
            }
            else {
                companies.put(companyName, new ArrayList<Enrollee>());
                companies.get(companyName).add(enrollee);
            }
        }

        return companies;

    }

    public static List<String> CSVtoString(String filepath) {
        List<String> csvStringList = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(filepath));
            scanner.nextLine();
            while(scanner.hasNextLine()) {
                csvStringList.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }

        return csvStringList;
    }

    public static List<Enrollee> parseCSVString(List<String> csvString) {

        List<Enrollee> enrollees = new ArrayList<Enrollee>();
        for(String word : csvString) {
            String[] words = word.split(",");
            try {
                enrollees.add(new Enrollee(words[0], words[1], words[2], Integer.parseInt(words[3]), words[4]));
            }
            catch(Exception e) {
                System.out.println("An error occurred");
                e.printStackTrace();
            }
        }

        return enrollees;
    }
}

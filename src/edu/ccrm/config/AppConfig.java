package edu.ccrm.config;


public class AppConfig {
    private static AppConfig instance;
    
   
    private String dataDirectory = "./data";
    private String backupDirectory = "./backups";
    private String exportDirectory = "./exports";
    private int maxCreditsPerSemester = 27; 
    
    private AppConfig() {
    }
    
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
    
   
    public String getDataDirectory() { return dataDirectory; }
    public String getBackupDirectory() { return backupDirectory; }
    public String getExportDirectory() { return exportDirectory; }
    public int getMaxCreditsPerSemester() { return maxCreditsPerSemester; }
    
    public void setDataDirectory(String dataDirectory) { this.dataDirectory = dataDirectory; }
    public void setBackupDirectory(String backupDirectory) { this.backupDirectory = backupDirectory; }
    public void setExportDirectory(String exportDirectory) { this.exportDirectory = exportDirectory; }
    public void setMaxCreditsPerSemester(int maxCredits) { this.maxCreditsPerSemester = maxCredits; }
    
    
    public void printConfig() {
        System.out.println("=== Vityarhi's CCRM Configuration ==="); 
        System.out.println("Data Directory: " + dataDirectory);
        System.out.println("Backup Directory: " + backupDirectory);
        System.out.println("Max Credits per Semester: " + maxCreditsPerSemester);
        System.out.println("===============================");
    }
}
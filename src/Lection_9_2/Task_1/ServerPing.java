package Lection_9_2.Task_1;

/*
*В файле хранится список веб-серверов. Надо проверить какие из серверов
* доступны в данный момент и создать отчет в формате сервер=статус.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ServerPing {

    private String serversPath;
    private String reportPath;

    public ServerPing(String serversPath, String reportPath) throws FileNotFoundException{

        this.serversPath = serversPath;
        this.reportPath = reportPath;

        File serverFile = new File(serversPath);
        if(!serverFile.exists() || !serverFile.isFile()) {
            throw new FileNotFoundException(serversPath);
        }
    }

    public void getStatucConnectionReport() throws InterruptedException, IOException{
        StringBuilder report = new StringBuilder();
        report.append(new Date())
                .append("\r\nServer - status:\r\n");

        List<String> addressList = getAddressList();

        for(String address : addressList) {
            int status = getStatusServer(address);
            report.append(address)
                    .append(" - ")
                    .append((status == 0 ? "reachable\r\n" : "unreachable\r\n"));
        }
        Files.write(reportPath, report);
    }

    private int getStatusServer(String address) throws InterruptedException, IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("ping " + address);
        int status = process.waitFor();
        return status;
    }

    public List<String> getAddressList() throws FileNotFoundException {
        String addresses = Files.read(serversPath);
        addresses = addresses.replace("https://", "").replace("https://", "");
        List<String> addressList = Arrays.asList(addresses.split("\n"));
        return addressList;
    }

    public String getServersPath() {
        return serversPath;
    }

    public void setServersPath(String serversPath) {
        this.serversPath = serversPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }
}

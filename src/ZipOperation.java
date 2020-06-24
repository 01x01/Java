/*
 * @Description: For zip file and unzip file and  read zipfile.
 * @author: johnw;
 * @Created: 6/23/2020;
 */

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipOperation {
    public static void main(String[] args) {
        ZipTool z = new ZipTool();
        try{
            //z.unzipFile("./java.zip","./test/");
            //z.zipFile("src", "./test.zip");
            z.readFile("./test.zip");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ZipTool{
    public int unzipFile(String filePath,String desc) throws IOException {
        ZipInputStream zip = null;
        ZipEntry entry = null;
        OutputStream out = null;
        InputStream sourceFilePath = new FileInputStream(filePath);
        int flag = -1;

        try{
            zip = new ZipInputStream(sourceFilePath);


            while ((entry = zip.getNextEntry())!=null){
                String path = entry.getName();


                if (entry.isDirectory()){

                    System.out.println("文件夹路径为： " + path);

                    File descFilePath = new File(desc+path);
                    if (!descFilePath.exists()){
                        descFilePath.mkdirs();
                    }
                }else{
                    out = new FileOutputStream(desc+path);
                    byte[] buff = new byte[1024];
                    int len;
                    while((len = zip.read(buff)) > 0 ){
                        out.write(buff,0,len);
                    }
                }
            }

            flag = 1;
        }finally {
            zip.close();
            out.close();
        }



        return flag;
    }
    public void readFile(String filePath)throws IOException{
        ZipInputStream zip = null;
        InputStream in = null;
        ZipEntry entry = null;
        try{
            in = new FileInputStream(filePath);
            zip = new ZipInputStream(in);
            while((entry = zip.getNextEntry()) != null) {
                String fileName = entry.getName();
                System.out.println(fileName);
            }

        }finally {
            zip.close();
            in.close();
        }
    }

    public int zipFile(String filePath, String zipFilePath) throws IOException{
        ZipOutputStream zip = null;
        OutputStream out = new FileOutputStream(zipFilePath);
        InputStream readZipFile = null;
        String realFilePath;
        try{
            zip = new ZipOutputStream(out);
            File files = new File(filePath);
            for(File file : files.listFiles()){

                realFilePath = filePath +"/"+ file.getName();
                zip.putNextEntry(new ZipEntry(realFilePath));
                readZipFile = new FileInputStream(realFilePath);
                int b;
                while((b = readZipFile.read())!= -1){
                    zip.write(b);
                }

            }
        }finally {
            zip.close();
            out.close();
            readZipFile.close();
        }
        return -1;
    }

}
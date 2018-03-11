package Src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Word
{
   public static void main(String[] args)throws Exception 
   {
   //Blank Document
   XWPFDocument doc =  new XWPFDocument(new FileInputStream("createdocument.docx")); 
   //Write the Document in file system
       
//     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//     con = DriverManager.getConnection("jdbc:odbc:ooad");
       
       XWPFWordExtractor we = new XWPFWordExtractor(doc);
 Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
   String ar = we.getText();
 PreparedStatement s1 = con.prepareStatement("insert into question values(?,?,?,?,?,?)");
  
  String quest = "\\d.*?(?=\n|$)";
  String option = "[A-D][.].*?(?=\\n|$|[A-D])";
  String ans = "Answer:.Option..";
  String sa[];
  Pattern p = Pattern.compile(quest);
  Pattern anss = Pattern.compile(option);
  Pattern asd = Pattern.compile(ans);
  Matcher m1 = anss.matcher(ar);
  Matcher m = p.matcher(ar);
  Matcher asdg = asd.matcher(ar);
  int i;
  while( m.find())
  {
      
      System.out.println(m.group());
   s1.setString(1,m.group());
   i=2;
while(i<6){
    m1.find();

    System.out.println(m1.group());
   s1.setString(i, m1.group().substring(2));
   i++;    
  }
 if(asdg.find())
 s1.setString(i,asdg.group().substring(7));
else
     s1.setString(i, " ");
 s1.executeUpdate();
  }      
   }
}
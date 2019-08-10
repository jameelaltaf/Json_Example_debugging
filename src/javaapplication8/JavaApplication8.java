/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 1894832
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
          String json = FileReader.loadFileIntoString("json/jsonLint.json","UTF-8");
        System.out.println(json);
        JSONObject student = JSONObject.fromObject(json);
        String firstName, lastName, DOB,street,zipcode,course, numbers = "";
        int number,mark;
        long studentId;
        double gpa;
        JSONObject address,marks;
        JSONArray phoneNumber;
        JSONArray results;
        String resultstr="";
        
     
            firstName = student.getString("firstName");
            lastName =  student.getString("LastName");
            DOB = student.getString("DOB");
            studentId = student.getLong("Id");
            gpa = student.getDouble("GPA");
            address = student.getJSONObject("Address");
            number = address.getInt("number");
            street = address.getString("Street");
            zipcode = address.getString("Zip");
            phoneNumber = student.getJSONArray("phoneNumber");
            System.out.println("--------");
            
            for(int j = 0; j<phoneNumber.size();j++)
            {
                
                numbers += phoneNumber.getString(j)+ "\n";
                //System.out.println(numbers);
            }
            results = student.getJSONArray("Result");
            for(int k=0; k<results.size(); k++)
            {
                 marks = results.getJSONObject(k);
                 course = marks.getString("course");
                 mark = marks.getInt("mark");
                 resultstr += course + " " + mark + "\n";
              //   System.out.println(course + "  " + mark);
            }
            System.out.println("{\n" + firstName + ",\n" + lastName + ",\n" + studentId + ",\n" + DOB + ",\n" + gpa + ",\n" + numbers + ",\n" + resultstr + ",\n}");
           
                 
        }
    }
    

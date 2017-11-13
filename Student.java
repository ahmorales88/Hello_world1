package edu.gatech;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by ahernan282 on 9/23/2017.
 */

public class Student {

    private int uusid;
    private String name;
    private String homeAddress;
    private long phoneNumber;
    private int degreeProgramID;
    private ArrayList<Integer> studentRequest = new ArrayList<Integer>();

    //Constructors

    public Student(){};
    public Student(int studentID, String studentName, String address, long phone, int programID){
        this.uusid = studentID;
        this.name = studentName;
        this.homeAddress = address;
        this.phoneNumber = phone;
        this.degreeProgramID = programID;
    }

    // Getter and Setters
    public int getUusid(){
        return uusid;
    }
    public void setUusid(int studentID){
        this.uusid = studentID;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(long phone){
        this.phoneNumber = phone;
    }
    public int getDegreeProgramID(){
        return degreeProgramID;
    }
    public void setDegreeProgramID(int csProgramID){
        this.degreeProgramID = csProgramID;
    }
    public String getName(){
        return name;
    }
    public void setName(String studentName){
        this.name = studentName;
    }
    public String getHomeAddress(){
        return homeAddress;
    }
    public void setHomeAddress(String address){
         this.homeAddress = address;
    }

    public void setStudentRequest(Integer request) {
        this.studentRequest.add(request);
    }
    public ArrayList<Integer> getStudentRequest() {
        return studentRequest;
    }


    public boolean checkPrerqs(ArrayList<StudentRecord> records, Course course) {

        boolean preReqsMet = false;
        int idFromStudent = this.uusid;

        if (course.getPrerequisite().isEmpty())
            preReqsMet = true;
        else {
            for (Integer i : course.getPrerequisite()) {
                for (StudentRecord sR : records) {
                    int idFromRecords = sR.getStudentID();
                    if (idFromRecords == idFromStudent) {
                        int courseId = sR.getCourseID();
                        if (i == courseId) {
                            char letterGrade = sR.getGrade();
                            if (letterGrade == 'A' || letterGrade == 'B' || letterGrade == 'C')
                                preReqsMet = true;
                            else
                                preReqsMet = false;
                        }
                    }
                }
            }
        }

        return preReqsMet;
    }



}

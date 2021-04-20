package edu.uw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import edu.uw.ext.framework.account.Account;
import edu.uw.ext.framework.account.AccountException;
import edu.uw.ext.framework.dao.AccountDao;

/**
 * The SimpleAccountDao class for the stock tracker project.
 * 
 * @author Toby Peterson.
 *
 */
public class SimpleAccountDao implements AccountDao {

    /**
     * The account property.
     */
    private Account account;

    /**
     * The hashmap property called accountsMap.
     */
    private HashMap<String, Object> accountsMap = new HashMap<String, Object>();

    /**
     * The path property.
     */
    String path = "target/accounts/";

    /**
     * The fos (FileOutputStream) property.
     */
    FileOutputStream fos;

    /**
     * The dos (DataOutputStream) property.
     */
    DataOutputStream dos;

    /**
     * The dis (DataInputStream) property.
     */
    DataInputStream dis;

    /**
     * The SimpleAccountDao no argument constructor.
     */
    public SimpleAccountDao() {
//        File file = new File("target/accounts/");
//        try {
//            file.createNewFile();
//            boolean flag = file.mkdir();
//            System.out.println("file created: " + flag);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    };

    /**
     * The close method for the SimpleAccountDao class.
     */
    @Override
    public void close() throws AccountException {
//        try {
//            dataOutput.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * The deleteAccount method for the SimpleAccountDao class.
     * 
     * @param accountName The account name to be deleted.
     */
    @Override
    public void deleteAccount(String accountName) throws AccountException {
        accountsMap.remove(accountName);
    }

    /**
     * The getAccount method for the SimpleAccountDao class.
     * 
     * @param accountName The account name to be retrieved.
     * @return Account The account to be returned.
     */
    @Override
    public Account getAccount(String accountName) {
        return (Account) accountsMap.get(accountName);
    }

    /**
     * The reset method for the SimpleAccountDao class.
     */
    @Override
    public void reset() throws AccountException {
        accountsMap.clear();
    }

    /**
     * The setAccount method for the SimpleAccountDao class.
     * 
     * @param account The account to be set.
     */
    @Override
    public void setAccount(Account account) throws AccountException {
        accountsMap.put(account.getName(), account);

//        File file = new File("target/accounts/" + account.getName());
//
//        try {
//            fos = new FileOutputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try (DataOutputStream dos = new DataOutputStream(fos)) {
//            dos.writeUTF(account.getName());
//            System.out.println("Successfully written data to the file:");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            di = new DataInputStream(new FileInputStream(file));
//        } catch (FileNotFoundException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//        try {
//            System.out.println("output: " + di.readUTF());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }

}

///**
// * StudentRecordWriter.java
// * This program illustrates how to use the DataOutputStream class for writing
// * data to a file.
// *
// * @author www.codejava.net
// */
//public class StudentRecordWriter {
//    DataOutputStream dataOutput;
// 
//    public StudentRecordWriter(String outputFile) throws IOException {
//        dataOutput = new DataOutputStream(new FileOutputStream(outputFile));
//    }
// 
//    public void write(Student student) throws IOException {
//        dataOutput.writeUTF(student.getName());
//        dataOutput.writeBoolean(student.getGender());
//        dataOutput.writeInt(student.getAge());
//        dataOutput.writeFloat(student.getGrade());
//    }
// 
//    public void save() throws IOException {
//        dataOutput.close();
//    }
// 
//    public static void main(String[] args) {
//        if (args.length < 1) {
//            System.out.println("Please provide output file");
//            System.exit(0);
//        }
// 
//        String outputFile = args[0];
// 
//        List<Student> listStudent = new ArrayList<>();
// 
//        listStudent.add(new Student("Alice", false, 23, 80.5f));
//        listStudent.add(new Student("Brian", true, 22, 95.0f));
//        listStudent.add(new Student("Carol", false, 21, 79.8f));
// 
//        try {
//            StudentRecordWriter writer = new StudentRecordWriter(outputFile);
// 
//            for (Student student : listStudent) {
//                writer.write(student);
//            }
// 
//            writer.save();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//}

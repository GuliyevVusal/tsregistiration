package file;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {

    public static void writeObjectToFile(Object obj, String objectFile) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(objectFile)))) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    public static Object readObject(String objectFile) throws Exception {
        try (ObjectInputStream iis = new ObjectInputStream(Files.newInputStream(Paths.get(objectFile)))) {
            return iis.readObject();
        }
    }
}

//    public static void writeTextToFile(String message) throws IOException {
//        Path filePath = Paths.get("file4.txt");
//        Files.write(filePath, message.getBytes(), StandardOpenOption.CREATE);
//    }
//
//    public static void readTextFile(String filePath) throws IOException {
//        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
//        String text = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println(text);
//    }
//
//    public static void writeImageToFile(String imagePath) throws IOException {
//        byte[] bytes = Files.readAllBytes(Paths.get(imagePath));
//        Path path = Paths.get("pattern-diagram2222.jpg");
//        Files.write(path, bytes, StandardOpenOption.CREATE);
//    }
//
//    public static void writeObjToFile() throws IOException {
//        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("User")))) {
//            User u = new User();
//            u.setName("Vusal");
//            u.setAge(33);
//            u.setPassword("111111");
//            oos.writeObject(u);
//            oos.flush();
//        }
//    }
//
//    public static void readObject() throws Exception {
//        try (ObjectInputStream iis = new ObjectInputStream(Files.newInputStream(Paths.get("User")))) {
//            Object obj = iis.readObject();
//            User user = (User) obj;
//            System.out.println(user.toString());
//        }
//    }
//
//    public static void writeTextToFileWithIo(String text) throws Exception {
//        try (FileOutputStream fos = new FileOutputStream("newtext.txt")) {
//            fos.write(text.getBytes(StandardCharsets.UTF_8));
//        }
//    }
//
//    public static void writeImageToFileWithIo(String image) throws Exception {
//        try (FileOutputStream fs = new FileOutputStream("myImage.jpg")) {
//            byte[] bytes = Files.readAllBytes(Paths.get(image));
//            fs.write(bytes);
//        }
//    }
//
//    public static void writeTextToFileWithIo_2(String text) throws IOException {
//        try (FileWriter fw = new FileWriter("newtext2.txt");
//             BufferedWriter bw = new BufferedWriter(fw)) {
//            bw.write(text);
//            bw.newLine();
//        }
//    }
//
//    public static void readFromTextFileWithBufferReader(String fileName) throws Exception {
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//    }
//
//}


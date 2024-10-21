package nghich;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;

public class CacheDataLoader {
    private static CacheDataLoader instance; // Đối tượng duy nhất của lớp
    private Hashtable<String, FrameImage> frameImages; // Hashtable để lưu trữ ảnh

    public static CacheDataLoader getInstance() {
        if (instance == null) instance = new CacheDataLoader();
        return instance;
    }

    // Hàm đọc và lưu ảnh vào Hashtable
    public void loadImages(String[] imagePaths) {
        frameImages = new Hashtable<>(); // Khởi tạo Hashtable

        for (String path : imagePaths) {
            try {
                // Đọc hình ảnh từ tệp
                BufferedImage image = ImageIO.read(new File(path));

                // Lấy tên tệp từ đường dẫn
                String fileName = new File(path).getName();
                
                // Tạo đối tượng FrameImage mới
                FrameImage frame = new FrameImage(fileName, image);

                // Thêm vào Hashtable
                frameImages.put(frame.getName(), frame);
            } catch (IOException e) {
                System.err.println("Error loading image: " + path + " - " + e.getMessage());
            }
        }
    }
    
    // Phương thức để lấy FrameImage theo tên
    public FrameImage getFrameImage(String name) {
        return frameImages.get(name);
    }
    public static void main(String[] args) {
        CacheDataLoader loader = CacheDataLoader.getInstance();
        
        // Danh sách các đường dẫn đến tệp PNG
        String[] imagePaths = {
            
            "Shark-attack1_1.png"
        };

        loader.loadImages(imagePaths); // Gọi hàm để thêm ảnh vào Hashtable
        
        // Kiểm tra xem ảnh đã được lưu hay chưa
        FrameImage frame = loader.getFrameImage("Shark-attack1_1.png"); // Lấy ảnh theo tên
        if (frame != null) {
            System.out.println("Image loaded: " + frame.getName());
        } else {
            System.out.println("Image not found.");
        }
    }

}

//proxy pettern

//Task 1
interface Image {
    void show();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        System.out.println("--> [SLOW] Reading " + fileName + " from hard drive...");
    }

    public void show() {
        System.out.println("Displaying " + fileName + " on screen!");
    }
}

class ProxyImage implements Image {
    private String fileName;
    private String userRole;
    private RealImage realImage;

    public ProxyImage(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }

    public void show() {
        if (!userRole.equals("ADMIN")) {
            System.out.println("[ACCESS DENIED] You lack permission to view: " + fileName);
            return;
        }
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.show();
    }
}

//Task 2
interface Video {
    void play();
}

class RealVideo implements Video {
    private String fileName;

    public RealVideo(String fileName) {
        this.fileName = fileName;
        System.out.println("--> [DOWNLOADING] Connecting to server & buffering 4K video: " + fileName);
    }

    public void play() {
        System.out.println("Playing video: " + fileName);
    }
}

class ProxyVideo implements Video {
    private String fileName;
    private RealVideo realVideo;
    private int viewCount = 0;

    public ProxyVideo(String fileName) {
        this.fileName = fileName;
    }

    public void play() {
        viewCount++;
        System.out.println("--> [AUDIT] Video has been played " + viewCount + " time(s).");
        if (realVideo == null) {
            realVideo = new RealVideo(fileName);
        }
        realVideo.play();
    }
}

//Task 3
interface Internet {
    void connectTo(String site);
}

class RealInternet implements Internet {
    public void connectTo(String site) {
        System.out.println("Connected to site: " + site);
    }
}

class SchoolProxyInternet implements Internet {
    private RealInternet realInternet;

    public void connectTo(String site) {
        if (site.equals("gaming.com") || site.equals("socialmedia.com")) {
            System.out.println("[BLOCKED BY FIREWALL] Cannot access: " + site);
            return;
        }
        if (realInternet == null) {
            realInternet = new RealInternet();
        }
        realInternet.connectTo(site);
    }
}

public class main6 {
    public static void main(String[] args) {
        //Task 1
        Image guest = new ProxyImage("salary_sheet.png", "GUEST");
        Image admin = new ProxyImage("salary_sheet.png", "ADMIN");
        guest.show();
        admin.show();
        System.out.println();

        //Task 2
        Video video = new ProxyVideo("Cat_Memes.mp4");
        video.play();
        System.out.println();
        video.play();
        System.out.println();
        video.play();
        System.out.println();

        //Task 3
        Internet internet = new SchoolProxyInternet();
        internet.connectTo("wikipedia.org");
        internet.connectTo("gaming.com");
    }
}
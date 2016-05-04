package data;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.*;
import java.sql.Date;
import java.util.*;


public class PostqreSqlTestData {

    private static final Random r = new Random();
    private static final String MEDIA_DIR = "D:/my-resume/src/main/webapp/media";
    private static final String PHOTO_PATH = "external/test-data/photos/";
    private static final String CERTIFICATES_PATH = "external/test-data/certificates/";

    private static final String COUTRY = "Ukraine";
    private static final String[] CITIES = { "Kharkiv", "Kiyv", "Odessa" };
    private static final String[] FOREGIN_LANGUAGES = { "Spanish", "French", "German", "Italian" };
    private static final String PASSWORD_HASH = "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq";
    private static final String[] HOBBIES = { "Cycling", "Handball", "Football", "Basketball", "Bowling", "Boxing", "Volleyball", "Baseball", "Skating", "Skiing", "Table tennis", "Tennis",
            "Weightlifting", "Automobiles", "Book reading", "Cricket", "Photo", "Shopping", "Cooking", "Codding", "Animals", "Traveling", "Movie", "Painting", "Darts", "Fishing", "Kayak slalom",
            "Games of chance", "Ice hockey", "Roller skating", "Swimming", "Diving", "Golf", "Shooting", "Rowing", "Camping", "Archery", "Pubs", "Music", "Computer games", "Authorship", "Singing",
            "Foreign lang", "Billiards", "Skateboarding", "Collecting", "Badminton", "Disco" };
    private static final List<String> HOBBIES_LIST = new ArrayList<>(Arrays.asList(HOBBIES));
    private static final String[] NAME = {"James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael", "Elizabeth", "William", "Linda", "David", "Barbara", "Richard", "Susan", "Joseph", "Margaret", "Charles", "Jessica", "Thomas", "Sar", "Christopher", "Dorot", "Daniel", "Kar", "Matthew", "Nan", "Donald", "Bet", "Anthony", "Li", "Mark", "Sand", "Paul", "Ashl", "Steven", "Kimber", "George", "Don", "Kenneth", "Helen","Andrew","Carol","Edward","Michelle","Joshua","Emily","Brian","Amanda","Kevin","Melissa","Ronald","Deborah","Timothy","Laura","Jason","Stephanie","Jeffrey","Rebecca","Ryan","Sharon","Gary","Cynthia","Nicholas","Kathleen","Eric","Anna","Jacob","Shirley","Stephen","Ruth","Jonathan","Amy","Larry","Angela","Frank","Brenda","Scott","Virginia","Justin","Pamela","Brandon","Catherine","Raymond","Katherine","Gregory","Nicole","Samuel","Christine","Benjamin","Samantha","Patrick","Janet","Jack","Debra","Dennis","Carolyn","Alexander","Rachel","Jerry","Heather","Tyler","Maria","Henry","Diane","Douglas","Julie","Aaron","Joyce","Peter","Emma","Jose","Frances","Walter","Evelyn","Adam","Joan","Zachary","Martha","Nathan","Christina","Harold","Kelly","Kyle","Lauren","Carl","Victoria","Arthur","Judith","Gerald","Alice","Roger","Ann","Keith","Cheryl","Lawrence","Jean","Jeremy","Doris","Terry","Megan","Albert","Marie","Joe","Andrea","Sean","Kathryn","Willie","Jacqueline","Christian","Gloria","Jesse","Teresa","Austin","Sara","Billy","Janice","Bruce","Hannah","Ralph","Julia","Bryan","Rose","Ethan",	"Theresa","Roy","Grace","Eugene","Judy","Jordan","Beverly","Louis","Olivia","Wayne","Denise","Alan","Marilyn","Harry","Amber","Russell","Danielle","Juan","Brittany","Dylan","Diana","Randy","Mildred","Philip","Jane","Vincent","Madison","Noah","Lori","Bobby","Tiffany","Howard","Kathy","Gabriel","Tammy","Johnny","Kayla"};
    private static final List<String> NAME_LIST = new ArrayList<>(Arrays.asList(NAME));
    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis. Nullam sagittis. Suspendisse pulvinar, augue ac venenatis condimentum, sem libero volutpat nibh, nec pellentesque velit pede quis nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Ut varius tincidunt libero. Phasellus dolor. Maecenas vestibulum mollis diam. Pellentesque ut neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In dui magna, posuere eget, vestibulum et, tempor auctor, justo. In ac felis quis tortor malesuada pretium. Pellentesque auctor neque nec urna. Proin sapien ipsum, porta a, auctor quis, euismod ut, mi. Aenean viverra rhoncus pede. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut non enim eleifend felis pretium feugiat. Vivamus quis mi. Phasellus a est. Phasellus magna. In hac habitasse platea dictumst. Curabitur at lacus ac velit ornare lobortis. Curabitur a felis in nunc fringilla tristique.";



    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/my-resume",
                            "my-resume", "my-resume");
            c.setAutoCommit(false);
            System.out.println("Opened database insert");

            //clearMedia();
           // crearDb(c);

            insertSkillCategory(c);
            int memberId =  insertMember(c);
            insertMemberInfo(c, memberId);
            insertSkill(c, memberId);
            insertLanguage(c, memberId);
            insertHobby(c, memberId);
            insertCourse(c, memberId);
            insertCertificate(c, memberId);
            insertEducation(c, memberId);
            insertPractic(c, memberId);

            c.commit();
            c.close();


        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    private static void crearDb(Connection c) throws SQLException{
        Statement st = c.createStatement();
        st.executeUpdate("DELETE FROM MEMBER");
        st.executeUpdate("DELETE FROM SKILL_CATEGORY");

        st.executeQuery("SELECT setval('member_seq', 1, FALSE)");
        st.executeQuery("SELECT setval('skill_seq', 1, FALSE)");
        st.executeQuery("SELECT setval('skill_category_seq', 1, FALSE)");
        st.executeQuery("SELECT setval('language_seq', 1, FALSE)");
        st.executeQuery("SELECT setval('hobby_seq', 1, FALSE)");
        st.executeQuery("SELECT setval('course_seq', 1, FALSE)");
        st.executeQuery("SELECT setval('certificate_seq', 1, FALSE)");
        st.executeQuery("SELECT setval('education_seq', 1, FALSE)");
        st.executeQuery("SELECT setval('practic_seq', 1, FALSE)");


        System.out.println("Db cleared");
    }

    private static void clearMedia() throws IOException {
        if (Files.exists(Paths.get(MEDIA_DIR))) {
            Files.walkFileTree(Paths.get(MEDIA_DIR), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        System.out.println("Media dir cleared");
    }

    private static List<String> loadProfiles() {
        File[] photos = new File(PHOTO_PATH).listFiles();
        List<String> list = new ArrayList<>(photos.length);

        for (File f : photos) {
            list.add(f.getAbsolutePath());
        }
        return list;
    }

    private static List<String> loadCertificates() {
        File[] files = new File(CERTIFICATES_PATH).listFiles();
        List<String> list = new ArrayList<>(files.length);

        for (File f : files) {
            list.add(f.getAbsolutePath());
        }
        return list;
    }



    public static int insertMember(Connection c) throws SQLException {
        String firstName = NAME_LIST.get(r.nextInt(NAME_LIST.size()));
        String lastName = NAME_LIST.get(r.nextInt(NAME_LIST.size()));

        PreparedStatement ps = c.prepareStatement("insert into member values (nextval('member_seq'),?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, Integer.toString(r.nextInt()) + "_" + (firstName + "_" + lastName).toLowerCase());
        ps.setString(2, PASSWORD_HASH);
        ps.setString(3, firstName);
        ps.setString(4, lastName);
        ps.setString(5, Integer.toString(r.nextInt()) + "_" + (firstName + "_" + lastName).toLowerCase() + "@gmail.com");
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int memberId = 0;
        if(rs.next()){
            memberId = rs.getInt(1);
        }
        ps.close();

        System.out.println("Insert Member :" + memberId);
        return memberId;
    }

    public static void insertMemberInfo(Connection c, int memberId) throws SQLException, IOException {
        String firstName = NAME_LIST.get(r.nextInt(NAME_LIST.size()));
        String lastName = NAME_LIST.get(r.nextInt(NAME_LIST.size()));

        PreparedStatement ps = c.prepareStatement("insert into member_info values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, memberId);
        ps.setNull(2, Types.DATE);
        ps.setString(3, generatePhone());

        ps.setString(4, COUTRY);
        ps.setString(5, CITIES[r.nextInt(CITIES.length)]);

        ps.setString(6, Integer.toString(r.nextInt()));
        ps.setString(7, Integer.toString(r.nextInt()));

        String uid = UUID.randomUUID().toString() + ".jpg";
        File photo = new File(MEDIA_DIR + "/avatar/" + uid);
        File photoSmall = new File(MEDIA_DIR + "/avatar-small/" + uid);
        if (!photo.getParentFile().exists()) {
            photo.getParentFile().mkdirs();
        }
        if (!photoSmall.getParentFile().exists()) {
            photoSmall.getParentFile().mkdirs();
        }
        Files.copy(Paths.get(loadProfiles().get(0)), Paths.get(photo.getAbsolutePath()));
        Thumbnails.of(photo).size(110, 110).toFile(new File(MEDIA_DIR + "/avatar-small/" + uid));
        ps.setString(8, uid);

        //ps.setString(8, Integer.toString(r.nextInt()));


        ps.setString(9, getRandomText());
        ps.setInt(10, 1);
        ps.setString(11, (firstName+ "-" + lastName).toLowerCase());
        ps.setString(12, "https://vk.com/" + (firstName+ "-" + lastName).toLowerCase());
        ps.setString(13, "https://facebook.com/" + (firstName+ "-" + lastName).toLowerCase());
        ps.setString(14, "https://linkedin.com/" + (firstName+ "-" + lastName).toLowerCase());
        ps.setString(15, "https://github.com/" + (firstName+ "-" + lastName).toLowerCase());
        ps.setString(16, "https://stackoverflow.com/" + (firstName+ "-" + lastName).toLowerCase());



        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Member Info");
    }

    public static void insertSkillCategory(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("insert into skill_category values (nextval('skill_category_seq'),?)");
        ps.setString(1, Integer.toString(r.nextInt()));
        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Skill Category");
    }

    public static void insertSkill(Connection c, int memberId) throws SQLException {
        PreparedStatement ps = c.prepareStatement("insert into skill values (nextval('skill_seq'),?,?,?)");
        ps.setInt(1, memberId);
        ps.setString(2, Integer.toString(r.nextInt()));
        ps.setString(3, Integer.toString(r.nextInt()));
        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Skill");
    }

    public static void insertLanguage(Connection c, int memberId) throws SQLException{
        PreparedStatement ps = c.prepareStatement("insert into language values (nextval('language_seq'),?,?,?)");
        ps.setInt(1, memberId);
        ps.setString(2, Integer.toString(r.nextInt()));
        ps.setString(3, Integer.toString(r.nextInt()));
        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Language");
    }

    public static void insertHobby(Connection c, int memberId) throws SQLException{
        PreparedStatement ps = c.prepareStatement("insert into hobby values (nextval('hobby_seq'),?,?)");
        ps.setInt(1, memberId);
        ps.setString(2, Integer.toString(r.nextInt()));
        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Hobby");
    }

    public static void insertCourse(Connection c, int memberId) throws SQLException{
        PreparedStatement ps = c.prepareStatement("insert into course values (nextval('course_seq'),?,?,?)");
        ps.setInt(1, memberId);
        ps.setString(2, Integer.toString(r.nextInt()));
        ps.setString(3, Integer.toString(r.nextInt()));
        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Course");
    }

    public static void insertCertificate(Connection c, int memberId) throws SQLException, IOException {
        PreparedStatement ps = c.prepareStatement("insert into certificate values (nextval('certificate_seq'),?,?,?)");
        ps.setInt(1, memberId);
        ps.setString(2, Integer.toString(r.nextInt()));

        String uid = UUID.randomUUID().toString() + ".jpg";
        File photo = new File(MEDIA_DIR + "/certificate/" + uid);
        File photoSmall = new File(MEDIA_DIR + "/certificate-small/" + uid);
        if (!photo.getParentFile().exists()) {
            photo.getParentFile().mkdirs();
        }
        if (!photoSmall.getParentFile().exists()) {
            photoSmall.getParentFile().mkdirs();
        }

        Files.copy(Paths.get(loadCertificates().get(0)), Paths.get(photo.getAbsolutePath()));
        String smallUid = uid.replace(".jpg", "-sm.jpg");
        Thumbnails.of(photo).size(110, 110).toFile(new File(MEDIA_DIR + "/certificate-small/" + smallUid));
        ps.setString(3, uid);



        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Certificate");
    }

    public static void insertEducation(Connection c, int memberId) throws SQLException{
        PreparedStatement ps = c.prepareStatement("insert into education values (nextval('education_seq'),?,?,?,?,?,?)");
        ps.setInt(1, memberId);
        ps.setString(2, Integer.toString(r.nextInt()));
        ps.setString(3, Integer.toString(r.nextInt()));
        ps.setString(4, Integer.toString(r.nextInt()));
        ps.setInt(5, 1990);
        ps.setInt(6, 1999);
        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Education");
    }

    public static void insertPractic(Connection c, int memberId) throws SQLException{
        PreparedStatement ps = c.prepareStatement("insert into practic values (nextval('practic_seq'),?,?,?,?,?,?,?,?)");
        Date finish = addField(new Date(System.currentTimeMillis()), Calendar.MONTH, -(r.nextInt(3) + 1), false);

        ps.setInt(1, memberId);
        ps.setString(2, Integer.toString(r.nextInt()));
        ps.setString(3, Integer.toString(r.nextInt()));
        ps.setDate(4, addField(finish, Calendar.MONTH, -1, false));
        ps.setDate(5, finish);
        ps.setString(6, Integer.toString(r.nextInt()));
        ps.setString(7, Integer.toString(r.nextInt()));
        ps.setString(8, Integer.toString(r.nextInt()));

        ps.executeUpdate();
        ps.close();
        System.out.println("Insert Practic");
    }


    private static Date addField(Date finish, int field, int value, boolean isBeginEducation) {
        Calendar cl = Calendar.getInstance();
        cl.setTimeInMillis(finish.getTime());
        cl.add(field, value);
        if (isBeginEducation) {
            cl.set(Calendar.DAY_OF_MONTH, 1);
            cl.set(Calendar.MONTH, Calendar.SEPTEMBER);
        }
        return new Date(cl.getTimeInMillis());
    }

    private static String getRandomText(){

        int textLength = TEXT.split("\\s+").length;
        StringTokenizer st = new StringTokenizer(TEXT);
        String randomText = "";
        for(int i = 0; i < r.nextInt(textLength) && st.hasMoreTokens(); i++) {
            randomText += st.nextToken() + " ";
        }
        return randomText;
    }
    private static String generatePhone() {
        StringBuilder phone = new StringBuilder("+38050");
        for (int i = 0; i < 7; i++) {
            int code = '1' + r.nextInt(9);
            phone.append(((char) code));
        }
        return phone.toString();
    }

}

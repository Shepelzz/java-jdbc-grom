package hibernate.lesson8.homework8_1.demo;

import hibernate.lesson8.homework8_1.controller.UserController;

public class DemoUser {
    public static void main(String[] args) throws Exception{
                //регистрация юзера
        try{
//            UserController userController = new UserController();
//            User user = new User();
//            user.setUserName("Test12");
//            user.setCountry("UR");
//            user.setPassword("1111");
//            user.setUserType(UserType.ADMIN);

            //System.out.println(userController.registerUser(user));
        }catch (Exception e){
            System.err.println(e.toString());
        }

        //логин
        try{
//            System.out.println(Session.getLoggedUser());
//
//            UserController userController = new UserController();
//            userController.login("Zhenya", "qwer1111");
//
//            System.out.println(Session.getLoggedUser());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        //System.out.println(UserDAO.getLoggedUser());

        //логаут
        //userController.logout();
        //System.out.println(UserDAO.getLoggedUser());

        //User user = new User("Zhenya", "qwer1111", "Ukraine", UserType.ADMIN);
        //System.out.println(Arrays.toString(user.getParametersList()));


        UserController userController = new UserController();
//        User user = new User();
//            user.setUserName("Test12");
//            user.setCountry("UR");
//            user.setPassword("1111");
//            user.setUserType(UserType.ADMIN);
        //userController.registerUser(user);

//        String path = "files/UserDb.txt";
//        FileReader fileReader = new FileReader(path);
//        try(BufferedReader br = new BufferedReader(fileReader); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
//            User user = new User();
//            user.setId(97883784723L);
//            user.setUserName("Test12");
//            user.setCountry("UR");
//            user.setPassword("1111");
//            user.setUserType(UserType.ADMIN);
//            if(br.readLine() != null)
//                bw.append("\r\n");
//            bw.append(user.toString());
//        } catch (IOException e){
//            throw new UnexpectedException("Writing to file error: can`t save to file "+path);
//        }

    }
}

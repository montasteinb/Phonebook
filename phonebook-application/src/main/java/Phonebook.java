import java.util.ArrayList;

public class Phonebook {
    public static void main(String[] args) {

    }
    ArrayList<User> users = new ArrayList<>();

        public String addUser (User user){
            users.add(user);
            return user.name + " \t " + user.phoneNumber + " \t" + user.email + " \t Added successfully";
        }
        public String removeUser (String userName){
            try {
                users.remove(userName);
            } catch (Exception ex) {
                return "Unable to remove specified user";
            }
            return userName + " User removed successfully";
        }

        public ArrayList<User> getAllUsers () {
            return users;
        }

        public String updateUser(int phoneNumber, User newUser) {
            if(this.users.get(phoneNumber) != null) {
                User oldUser = this.users.get(phoneNumber);

                oldUser.name = newUser.name;
                oldUser.phoneNumber = newUser.phoneNumber;

                return newUser + "user updated successfully";
            }
            return "User not found";
        }

}



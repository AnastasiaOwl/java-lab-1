package pack;


import java.time.LocalDate;
import java.util.*;

public class Logic {
    public List<Customer> fillList() {
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("Volkov", "Nikita", "Viktorovich", LocalDate.of(2001, 05, 14), "vyl. Sadova 34", 878976657, 3456.50));
        list.add(new Customer("Sova", "Maria", "Sergievna", LocalDate.of(1998, 03, 11), "vyl. Faleevskay", 789989776, 55678.00));
        list.add(new Customer("Devikova", "Anna", "Andriivna", LocalDate.of(1973, 06, 21), "vyl. Soborna", 987678967,2344556.25 ));
        list.add(new Customer("Stepach", "Sergiy", "Aleksandrovich", LocalDate.of(2001, 10, 10), "vyl. Soborna", 878976687, -3224.40));
        list.add(new Customer("Filinov", "Nikita", "Oleksiyvich", LocalDate.of(1997, 05, 22), "vyl. Mira", 456757892,55678.00 ));
        list.add(new Customer("Vinkova", "Svetlana", "Aleksandrovna", LocalDate.of(1975, 01, 14), "vyl. Bila", 987654353,-345.78 ));
        list.add(new Customer("Sokolov", "Igor", "Andrievich", LocalDate.of(2000, 02, 15), "vyl. Stadion", 234569764,-1234.70 ));
        list.add(new Customer("Rydik", "Anna", "Viktorovna", LocalDate.of(2003, 05, 01), "vyl. Mira", 456776432, 324165.00));
        list.add(new Customer("Petrov", "Ivan", "Antonovich", LocalDate.of(1997, 07, 24), "vyl. Nadeshda", 678787543, 3456.50));
        return list;
    }
    public List<Customer> AddToList( List<Customer> list, String addSurname, String addName, String addPatronymic, LocalDate addBirthDate, String addAddress, long addCardNumber, double addCardBalance) {
        list.add(new Customer(addSurname, addName, addPatronymic, addBirthDate, addAddress,  addCardNumber,addCardBalance));
        return list;
    }

    public List<Customer> remove(List<Customer> list, int index) {
        list.remove(index);
        return list;
    }
    public List<Customer> name(List<Customer> list, String nameSearch) {
        ArrayList<Customer> findedList = new ArrayList();
        for (Customer customer : list) {
            if (Objects.equals(customer.name, nameSearch)) {
                findedList.add(customer);
            }
        }
        return findedList;
    }
    public List<Customer> cardNumber(List<Customer> list, long cardNumberF, long cardNumberT) {
        ArrayList<Customer> findedList1 = new ArrayList();
        for (Customer customer : list) {
            if (customer.cardNumber < cardNumberT && customer.cardNumber > cardNumberF) {
                findedList1.add(customer);
            }
        }
        return findedList1;
    }

    public ArrayList<Customer> cardBalance(List<Customer> list, int qCardBalance) {
        ArrayList<Customer> findedList2 = new ArrayList();
        for (Customer customer : list) {
            if (customer.cardBalance < 0)
            {
                findedList2.add(customer);
                qCardBalance++;
            }
        }
        findedList2.sort(Comparator.comparing(Customer::getCardBalance));
        Collections.reverse(findedList2);
        return findedList2;
    }
    public int qCardBalance(List<Customer> list, List<Customer> findedList2, int qCardBalance) {
        cardBalance(list,qCardBalance);
        qCardBalance= findedList2.size();
        return qCardBalance;
    }

   public List<Customer> sortByCardBalanceCardNumber(List<Customer> list) {
        list.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                int v = Double.compare(o1.getCardBalance(),o2.getCardBalance());
                if(v == 0) {
                    return Long.compare(o1.getCardNumber(),o2.getCardNumber());
                }
                return v;
            }
        });
       return list;
    }
    public HashSet sortByBirthYear(List<Customer> list) {
       HashSet h= new HashSet();
       for(Customer customer : list){
           h.add(customer.birthDate.getYear());
       }
        return h;
    }
    public Map<Integer,Customer> sortYearCardBalance(List<Customer> list) {
        Map<Integer, Customer> map= new HashMap<>();
        list.sort(Comparator.comparing(Customer::getCardBalance));
        for(Customer customer : list){
           map.put(customer.birthDate.getYear(), customer);
        }
        return map;
    }

}

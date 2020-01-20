package app;

import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, i);
        }

        Employee emp = employees.get((map.get(id)));

        return getSubImportance(emp, map, employees);
    }

    public int getSubImportance(Employee emp, HashMap<Integer, Integer> map, List<Employee> employees) {
        int res = emp.importance;

        if (emp.subordinates != null) {
            for (int subId : emp.subordinates) {
                int subIndex = map.get(subId);
                Employee subEmployee = employees.get(subIndex);

                res += getSubImportance(subEmployee, map, employees);
            }
        }

        return res;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                Employee current = employees.get(i);
                int importance = current.importance;

                for (int j = 0; j < current.subordinates.size(); j++) {
                    importance += getImportance(employees, current.subordinates.get(j));
                }

                return importance;
            }
        }

        return 0;
    }
}

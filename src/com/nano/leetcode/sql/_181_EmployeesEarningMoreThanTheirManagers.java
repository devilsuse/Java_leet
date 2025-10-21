package com.nano.leetcode.sql;

/*
181. Employees Earning More Than Their Managers
Easy
Topics
premium lock icon
Companies
SQL Schema
Pandas Schema
Table: Employee

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| salary      | int     |
| managerId   | int     |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.


Write a solution to find the employees who earn more than their managers.

Return the result table in any order.

The result format is in the following example.



Example 1:

Input:
Employee table:
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | Null      |
| 4  | Max   | 90000  | Null      |
+----+-------+--------+-----------+
Output:
+----------+
| Employee |
+----------+
| Joe      |
+----------+
Explanation: Joe is the only employee who earns more than his manager.
 */
public class _181_EmployeesEarningMoreThanTheirManagers {
    /*
    # Write your MySQL query statement below
    select e1.name as "Employee" from
    Employee e1 inner join Employee e2
    on e1.managerId = e2.id
    where e1.salary > e2.salary

    // PANDAs
    import pandas as pd

    def find_employees(employee: pd.DataFrame) -> pd.DataFrame:
        """
        Finds employees whose salary is strictly greater than their manager's salary.
        """
        # 1. Prepare DataFrames for joining
        # 'e' for Employee (the person being checked)
        employee_df_e = employee.rename(columns={'salary': 'employee_salary'})

        # 'm' for Manager (the person managing)
        employee_df_m = employee[['id', 'salary']].rename(
            columns={'id': 'managerId', 'salary': 'manager_salary'}
        )

        # 2. Perform a Left Merge (Self-Join)
        # Join the employee list (e) with the manager list (m)
        # on e.managerId = m.managerId (which is the manager's id)
        merged_df = employee_df_e.merge(
            employee_df_m,
            on='managerId',
            how='left'
        )

        # 3. Filter the results
        # Keep only the rows where the employee's salary is strictly greater
        # than the manager's salary.
        result = merged_df[merged_df['employee_salary'] > merged_df['manager_salary']]

        # 4. Select and return the required column ('name' aliased as 'Employee')
        return result[['name']].rename(columns={'name': 'Employee'})

     */
}

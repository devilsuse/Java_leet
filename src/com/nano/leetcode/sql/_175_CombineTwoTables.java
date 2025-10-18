package com.nano.leetcode.sql;

/*
175. Combine Two Tables
Solved
Easy
Topics
premium lock icon
Companies
SQL Schema
Pandas Schema
Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| personId    | int     |
| lastName    | varchar |
| firstName   | varchar |
+-------------+---------+
personId is the primary key (column with unique values) for this table.
This table contains information about the ID of some persons and their first and last names.


Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| addressId   | int     |
| personId    | int     |
| city        | varchar |
| state       | varchar |
+-------------+---------+
addressId is the primary key (column with unique values) for this table.
Each row of this table contains information about the city and state of one person with ID = PersonId.


Write a solution to report the first name, last name, city, and state of each person in the Person table. If the address of a personId is not present in the Address table, report null instead.

Return the result table in any order.

The result format is in the following example.



Example 1:

Input:
Person table:
+----------+----------+-----------+
| personId | lastName | firstName |
+----------+----------+-----------+
| 1        | Wang     | Allen     |
| 2        | Alice    | Bob       |
+----------+----------+-----------+
Address table:
+-----------+----------+---------------+------------+
| addressId | personId | city          | state      |
+-----------+----------+---------------+------------+
| 1         | 2        | New York City | New York   |
| 2         | 3        | Leetcode      | California |
+-----------+----------+---------------+------------+
Output:
+-----------+----------+---------------+----------+
| firstName | lastName | city          | state    |
+-----------+----------+---------------+----------+
| Allen     | Wang     | Null          | Null     |
| Bob       | Alice    | New York City | New York |
+-----------+----------+---------------+----------+
Explanation:
There is no address in the address table for the personId = 1 so we return null in their city and state.
addressId = 1 contains information about the address of personId = 2.
 */
public class _175_CombineTwoTables {

    /*
    My Approach 1:
    # Write your MySQL + PostgreSQL + MS SQL(T-SQL) query statement below
        select p.firstName, p.lastName, a.city, a.state from
        Person p left join Address a
        on p.personId = a.personId

    My Approach 2:
        -- ORACLE(PL/SQL) Old syntax
        select p.firstName, p.lastName, a.city, a.state from
        Person p, Address a
        where p.personId = a.personId(+);
     */

    /*
    pandas
        Approach 1: Using merge
        import pandas as pd

        def combine_two_tables(person: pd.DataFrame, address: pd.DataFrame) -> pd.DataFrame:
            result = pd.merge(person, address, on='personId', how='left')
            result = result[['firstName', 'lastName', 'city', 'state']]
            return result

    Database
        Approach 1: Using outer join
        Intuition
        Since the PersonId in table Address is the foreign key of table Person, we can join these two tables to get the address information of a person.

        Considering there might be no address information for every person, we should use outer join instead of the default inner join.

        Implementation
        Note: For MySQL, an outer join is performed either using left join or right join.

        select FirstName, LastName, City, State
        from Person left join Address
        on Person.PersonId = Address.PersonId;

Note: Using the where clause to filter the records will fail if there is no address information for a person because it will not display the name information.

     */
}

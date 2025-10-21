package com.nano.leetcode.sql;
/*
182. Duplicate Emails
Easy
Pandas Schema
Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table contains an email. The emails will not contain uppercase letters.


Write a solution to report all the duplicate emails. Note that it's guaranteed that the email field is not NULL.

Return the result table in any order.

The result format is in the following example.



Example 1:

Input:
Person table:
+----+---------+
| id | email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
Output:
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Explanation: a@b.com is repeated two times.
 */
public class _182_Duplicate_Emails {
    /*
    # Write your MySQL query statement below
    select email from (
    select email, count(email) "count" from Person
    group by email
    having count > 1
    ) a where count>1;

    #GEMINI answer:
    Solving the LeetCode problem "Duplicate Emails" requires finding all emails that appear more than once in the Person table. Here are the common ways to solve this using SQL, which is the necessary language for this type of problem.

The Person table has the columns: id (primary key) and email (varchar).

1. Using GROUP BY and HAVING
This is the most standard and often the most efficient way to solve this type of problem.

SQL

SELECT
    email
FROM
    Person
GROUP BY
    email
HAVING
    COUNT(email) > 1;
2. Using a Self-Join
This method joins the Person table to itself and selects emails where a different id has the same email, ensuring the email is duplicated.

SQL

SELECT DISTINCT
    p1.email
FROM
    Person p1,
    Person p2
WHERE
    p1.email = p2.email
    AND p1.id <> p2.id;
Explanation: The join condition p1.email = p2.email finds pairs of rows with the same email. The condition p1.id <> p2.id ensures that the two rows being compared are distinct records, thereby confirming the email is a duplicate. DISTINCT is used to return each duplicate email only once.

3. Using a Subquery with IN
This approach finds the duplicated emails first by using GROUP BY and HAVING in a subquery, and then uses that result set in the outer query to select the distinct emails.

SQL

SELECT DISTINCT
    email
FROM
    Person
WHERE
    email IN (
        SELECT
            email
        FROM
            Person
        GROUP BY
            email
        HAVING
            COUNT(email) > 1
    );
Note: While functional, this is often less efficient than the direct GROUP BY and HAVING approach (Method 1) because it involves a subquery.

4. Using a Window Function (e.g., COUNT() OVER)
Window functions can count the occurrences of each email without collapsing the rows (like GROUP BY does). This is typically used with a Common Table Expression (CTE) or subquery.

SQL

WITH EmailCounts AS (
    SELECT
        email,
        COUNT(email) OVER (PARTITION BY email) AS email_count
    FROM
        Person
)
SELECT DISTINCT
    email
FROM
    EmailCounts
WHERE
    email_count > 1;
Explanation:

The COUNT(email) OVER (PARTITION BY email) function counts the number of rows for each unique email and assigns that count to every row belonging to that email.

The outer query (or the CTE/subquery result) then filters for rows where email_count is greater than 1, indicating a duplicate, and uses DISTINCT to show each duplicate email only once.

Pandas:
import pandas as pd

def duplicate_emails(person: pd.DataFrame) -> pd.DataFrame:
    """
    Finds all duplicate emails in the Person DataFrame,
    returning a DataFrame with a single column 'Email'.
    """

    # 1. Group by 'email' and count the occurrences.
    # The 'size()' method is often faster than value_counts()
    # when following up with a filter based on the count.
    counts = person.groupby('email').size()

    # 2. Filter the counts to find emails with count > 1.
    duplicate_series = counts[counts > 1]

    # 3. The index of the resulting Series contains the duplicate emails.
    # Convert this index to a DataFrame with the *exact* required column name: 'Email'.
    # Resetting the index before converting to a DataFrame is a clean way
    # to move the email addresses from the index to a column.

    # Use the index directly and name the column:
    duplicate_emails_index = duplicate_series.index

    # Crucial step: Create the final DataFrame with the correct column name 'Email'
    result_df = pd.DataFrame({'Email': duplicate_emails_index})

    return result_df
     */
}

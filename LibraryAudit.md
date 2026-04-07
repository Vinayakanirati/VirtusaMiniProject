**DIGITAL LIBRARY**
*ddl commands*
-- Create Books Table
CREATE TABLE Books (
    BookID INT PRIMARY KEY,
    Title VARCHAR(100),
    Author VARCHAR(100),
    Category VARCHAR(50),
    AvailableCopies INT
);

-- Create Students Table
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    JoinDate DATE
);

-- Create IssuedBooks Table
CREATE TABLE IssuedBooks (
    IssueID INT PRIMARY KEY,
    BookID INT,
    StudentID INT,
    IssueDate DATE,
    ReturnDate DATE,
    FOREIGN KEY (BookID) REFERENCES Books(BookID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
);

**Students with overdue**

select s.StudentID , s.Name , b.title,ib.issuedDate, DATEDIFF(CURDATE(),ib.IssueDtae) AS DaysOverdue
from issuedBooks ib join
Students s on ib.StudentID =s.StudentID,
join Books b on b.bookID =ib.BookID where 
ib.ReturnDate IS null and 
DATEDIFF(CURDATE(),ib.IssuedDate)>14;

**popularity index**
SELECT
    b.Category,
     COUNT(*) AS TotalBorrows
    FROM IssuedBooks ib
     JOIN Books b ON ib.BookID = b.BookID
     GROUP BY b.Category
     ORDER BY TotalBorrows DESC;

**INACTIVE USERS**

ALTER TABLE Students ADD Status VARCHAR(20) DEFAULT 'Active';

UPDATE Students
SET Status = 'Inactive'
WHERE StudentID NOT IN (
    SELECT DISTINCT StudentID 
    FROM IssuedBooks
    WHERE IssueDate >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR)
);
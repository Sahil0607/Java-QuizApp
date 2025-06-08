SELECT * FROM public.question
ORDER BY id ASC 

INSERT INTO public.question
(id, category, difficultylevel,option1,option2,option3,option4,question_title, right_answer)
VALUES 
    (1, 'Java', 'Easy', 'Class', 'interface', 'extends', 'implements', 'which java keyword is used to create a subclass?', 'extends'),
    (2, 'Java', 'Easy', '4', '5', '6', 'compile error', 'what is the output of the following code snippet?', '5'),
    (3, 'Java', 'Easy', 'true', 'false', '0', 'null', 'In Java,what is the default value of a uninitialized boolean variable?', 'false'),
    (4, 'Java', 'Easy', 'try', 'throw', 'catch', 'finally', 'which java keyword is used to explicitly throw exceptions?', 'throw'),
    (5, 'Java', 'Easy', 'It indicated that var is constant', 'Indicated that method can be accessed without creating an instance of the class', 'Class cannot extended', 'variable is of premitive type', 'what does ststaic keyword indicate in Java?', 'Indicated that method can be accessed without creating an instance of the class'),
    (6, 'Java', 'Easy', 'const int x = 5;', 'final int x = 5;', 'readonly int x = 5;', 'readonly int x = 5;', 'what is the correct way to declare a constant variable in Java?', 'final int x = 5;'),
    (7, 'Java', 'Easy', 'for loop', 'while loop', 'do-while lopp', 'switch loop', 'what loop in java allows the code tobe executed at least once?', 'do-while loop'),
    (8, 'Java', 'Easy', 'terminate a loop or switch statement and trransfer control to the statement following the terminated statement', 'to skip the rest of the code in a loop and continue with the next iteration', 'to define a label for a loop or switch statement', 'to check condition and excceute the code block if the condition is true', 'what is the purpose of break statement in Java?', 'terminate a loop or switch statement and trransfer control to the statement following the terminated statement'),
    (9, 'Java', 'Easy', '+', '-', '*', '/', 'which java operator is used to concate two string?', '+'),
    (10, 'Java', 'Easy', 'Hashmap', 'ArrayList', 'LinkedList', 'HashSet', 'In Java, which collention calss provides an implemnetation of a dynamic array?', 'ArrayList'),
    (11, 'Python', 'Easy', 'count()', 'size()', 'length()', 'len()', 'which python function is used to calculate length of list?', 'len()'),
    (12, 'Python', 'Easy', '[1,2,3]', '[1,2,3,4]', '[4,3.2,1]', 'Error', 'what is the output of the following python code snippet?', '[1,2,3,4]'),
    (13, 'Python', 'Easy', 'break', 'continue', 'pass', 'return', 'which python statement is used to exit a loop prematurly?', ''),
    (14, 'Python', 'Easy', 'To generate rendom numbers', 'to iterate over sequence number', 'To sort a list in asc order', 'To calculate the length of a string', 'what is the purpose of range() function in Python?', 'To iterate over sequence number'),
    (15, 'Python', 'Easy', 'int', 'float', 'str', 'list', 'In python, which data type is mutatble?', 'list'),
    (16, 'Python', 'Easy', 'datetime', 'math', 'os', 'sys', 'which python module is used to work with dates and times?', 'datetime')


	
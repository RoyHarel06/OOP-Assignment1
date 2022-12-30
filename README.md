# OOP-Assignment1
 This repository includes 3 classes, the appropriate interfaces and testing suites.
 
 The class 'UndoableStringBuilder' (at 'OOP-Assignment1/src/main/java/observer/UndoableStringBuilder.java'): <br>
 A rework of 'StringBuilder' that contains the undo method, which supports the following methods: Append, Delete, Insert, Replace and Reverse.
 This class is from the previus assignment, therefore I will not go into details.
 
 The class 'GroupAdmin' (at 'OOP-Assignment1/src/main/java/observer/GroupAdmin.java'): <br>
 Serves as the subject in the Observer design pattern and implements the 'Sender' interface (at 'OOP-Assignment1/src/main/java/observer/Sender.java'). Holds an instance of 'UndoableStringBuilder'.
 
 The class 'ConcreteMember' (at 'OOP-Assignment1/src/main/java/observer/ConcreteMember.java'): <br>
 Serves as the observer in the Observer design pattern and implements the 'Member' interface (at 'OOP-Assignment1/src/main/java/observer/Member.java'). Holds a shalolow copy of the 'UndoableStringBuilder' 'GroupAdmin' holds.
 
 To use those classes in combination you wopuld first create and instance of 'GroupAdmin', add to it your desired 'Member's and from then on you can use 'GroupAdmin' and it will update all members automatically.
 
 You could look at our test (at 'OOP-Assignment1/src/test/java/observer/ObserverTest.java') for basic code aexamples.

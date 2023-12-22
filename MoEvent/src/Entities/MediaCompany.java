package Entities;


import DataStructures.Queue;
import DataStructures.Stack;

public class MediaCompany {
    private int companyId;
    private String companyName;
    Queue<Contract> sentContracts;
    Queue<Contract> receivedContracts;
    Stack<Contract> processedContracts;

}

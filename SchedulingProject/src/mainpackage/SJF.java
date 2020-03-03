/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author 光る諒
 */
public class SJF {
    private static final int P_LENGTH = 4;
    
    public SJF() {
    }
    public void sortProcess(Process[] p) {
        int min = 0, minIndex = 0;
        String minProcess = "";
        
        for (int i = 0; i < (P_LENGTH - 1); i++) {
            min = p[i].burstTime;
            minIndex = i;
            minProcess = p[i].processNumber;
            for (int j = (i + 1); j < P_LENGTH; j++) {
                if (p[j].burstTime < min) {
                    min = p[j].burstTime;
                    minIndex = j;
                    minProcess = p[j].processNumber;
                }
            }
            p[minIndex].burstTime = p[i].burstTime;
            p[i].burstTime = min;
            p[minIndex].processNumber = p[i].processNumber;
            p[i].processNumber = minProcess;
        }
    }
    public void displayArray(Process[] array) {
        for (int i = 0; i < P_LENGTH; i++) {
            System.out.println(array[i].processNumber + ": " + array[i].burstTime);
        }
    }
}

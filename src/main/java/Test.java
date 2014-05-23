

import java.util.HashMap;
import java.util.Map;

public class Test {
          public static void main(String args[]){
                  int n = 4;
                  char a[] = {'1','2','9','3'};  //1->2->9->3
                  int m = 3;
                  char b[] = {'9','9','3'};     //9->9->-3
                                                                                 // A-> B ->C ->3
                  Map<Integer, Character>D2Hexmap = new HashMap<Integer, Character>();
                  D2Hexmap.put(0, '0');
                  D2Hexmap.put(1, '1');
                  D2Hexmap.put(2, '2');
                  D2Hexmap.put(3, '3');
                  D2Hexmap.put(4, '4');
                  D2Hexmap.put(5, '5');
                  D2Hexmap.put(6, '6');
                  D2Hexmap.put(7, '7');
                  D2Hexmap.put(8, '8');
                  D2Hexmap.put(9, '9');
                  D2Hexmap.put(10, 'A');
                  D2Hexmap.put(11, 'B');
                  D2Hexmap.put(12, 'C');
                  D2Hexmap.put(13, 'D');
                  D2Hexmap.put(14, 'E');
                  D2Hexmap.put(15, 'F');
                  
                  Map<Character, Integer>Hex2Dmap = new HashMap<Character, Integer>();
                  Hex2Dmap.put('0', 0) ;
                  Hex2Dmap.put('1', 1);
                  Hex2Dmap.put('2', 2);
                  Hex2Dmap.put('3', 3);
                  Hex2Dmap.put('4', 4);
                  Hex2Dmap.put('5', 5);
                  Hex2Dmap.put('6', 6);
                  Hex2Dmap.put('7', 7);
                  Hex2Dmap.put('8', 8);
                  Hex2Dmap.put('9', 9);
                  Hex2Dmap.put('A', 10);
                  Hex2Dmap.put('B', 11);
                  Hex2Dmap.put('C', 12);
                  Hex2Dmap.put('D', 13);
                  Hex2Dmap.put('E', 14);
                  Hex2Dmap.put('F', 15);
                  
                  
                 
                  node p = initial(a , n);   // 1 2 9 3
                  node q = initial(b, m);
                  node res = addlink(p,q,D2Hexmap,Hex2Dmap );   //9 9 3
                  
                  while(p!=null){
                          if(p.next == null){
                                  System.out.print(p.data);
                                  System.out.print('\n');
                                  System.out.print('\n');
                                  System.out.print('\n');
                               p = p.next;
                          }
                          else{
                            System.out.println(p.data + "-->");
                            p = p.next;
                          }
                  }
                  
                  
                  while(q!=null){
                          if(q.next == null){
                                  System.out.print(q.data);
                                  System.out.print('\n');
                                  System.out.print('\n');
                                  System.out.print('\n');
                          q = q.next;
                          }
                          else{
                            System.out.println(q.data + "-->");
                            q = q.next;
                          }
                  }
                  
                  while(res!=null){
                          if(res.next == null){
                                  System.out.print(res.data);
                                  res = res.next;
                          }
                          else{
                            System.out.println(res.data + "-->");
                            res = res.next;
                          }
                  }
           }
          
          static node initial(char a[], int n){
                  node head = null;
                  node p = null;
                  for(int i = 0; i<n ;i++){
                          node nd = new node();
                          nd.data = a[i];
                          if(0 == i){
                                  p = nd;
                                  head = p;
                                  continue;
                          }
                          p.next = nd;
                          p = nd;
                  }
                  return head;
          }
           
          static node addlink(node p, node q, Map<?,?> D2Hexmap, Map<?,?> Hex2Dmap ){
                  if(p == null)return q;
                  if(q == null)return p;
                  node res = null;
                  node pre = null ;
                  int c = 0;
                  while(p!=null && q !=null){
                          int t  = (Integer) Hex2Dmap.get(p.data) +(Integer) Hex2Dmap.get(q.data)+c;
                          node r = new node();

                          int resultKey= t%16;
                          
                          r.data =  (Character) D2Hexmap.get(resultKey);
                          
                          if(pre != null){
                                  pre.next = r;
                                  pre = r;
                          }else{
                                  res = r;
                                  pre = res;
                          }
                          
                          c = t/16;
                          p = p.next;
                          q=q.next;
                          
                  }
                  
                  while(q != null){
                          char key = q.data;
                          int t = (Integer) Hex2Dmap.get(key) +c;
                          
                          node r = new node();
                          
                          int resultKey= t%16;
                          
                          r.data =  (Character) D2Hexmap.get(resultKey);
                          
                          pre.next = r;
                          pre = r;
                          c = t/16;
                          q = q.next;
                  }
                  
                  while(p != null){
                          char key = p.data;
                          int t = (Integer) Hex2Dmap.get(key) +c;
                          
                          node r = new node();
                          
                          int resultKey= t%16;
                          
                          r.data =  (Character) D2Hexmap.get(resultKey);
                          
                          pre.next = r;
                          pre = r;
                          c = t/16;
                          p = p.next;
                  }
                  
                  
                  if(c>0){
                          node r = new node();
                            
                          r.data =  (Character) D2Hexmap.get(c);
                         // r.data = c;
                          pre.next = r;
                  }
                  
                  return res;
          }
         
}


class node{
         char data;
         node next;
        }

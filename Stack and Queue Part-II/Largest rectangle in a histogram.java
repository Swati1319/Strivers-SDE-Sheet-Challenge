import java.util.ArrayList;
import java.util.Stack;
public class Solution {
  public static int largestRectangle(ArrayList < Integer > a) {
    // Write your code here.
      int maxArea=0;
        int ps[]=prevSmaller(a);
        int ns[]=nextSmaller(a);

        for(int i=0;i<a.size();i++)
        {
            int width=ps[i]-ns[i]-1;
            int area=a.get(i)*width;
            if(area>maxArea)
            {
                maxArea=area;
            }
        }

        return maxArea;
    }

    static int []prevSmaller(ArrayList<Integer>a)
    {
        int ps[]=new int[a.size()];
        Stack<Integer>s=new Stack<>();
        s.push(a.size()-1);

        ps[a.size()-1]=a.size();

        for(int i=a.size()-2;i>=0;i--)
        {
            while(s.size()>0&& a.get(s.peek())>=a.get(i))
            {
                s.pop();
            }
            if(s.size()==0)
            {
                ps[i]=a.size();
            }
            else{
                ps[i]=s.peek();
            }
            s.push(i);
        }

        return ps;
    }
     static int []nextSmaller(ArrayList<Integer>a)
    {
        int ns[]=new int[a.size()];
        Stack<Integer>s=new Stack<>();
        s.push(0);
        ns[0]=-1;
        for(int i=1;i<a.size();i++)
        {
            while(s.size()>0&&a.get(s.peek())>=a.get(i))
            {
                s.pop();
            }
            if(s.size()==0)
            {
                ns[i]=-1;
            }
            else
            {
                ns[i]=s.peek();
            }
            s.push(i);
        }

        return ns;
  }
}

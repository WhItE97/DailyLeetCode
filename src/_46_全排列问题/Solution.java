package _46_全排列问题;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public List<List<Integer>> permute(int[] nums){
		LinkedList<Integer> route = new LinkedList<Integer>();//pollLast()将最后一个元素出队；add()添加一个元素到队尾
		LinkedList<Integer> choices = new LinkedList<Integer>();
		for(int i=0;i<nums.length;i++) {
			choices.add(nums[i]);
		}
		backtrack(route,choices);
		System.out.println(res.toString());
		return res;
	}
	
	List<List<Integer>> res = new LinkedList<>();
	
	public void backtrack(LinkedList<Integer> route,LinkedList<Integer> choices){
		//因为这个函数会被递归调用，所以要先设置结束条件
		//if(满足条件)：
		//	result.add(路径)
		//	return
		if(route.size()==choices.size()) {
			res.add(new LinkedList(route));//HDPPPPPP!这里不能直接add(route)，而必须add(new LinkedList(route))！因为：
			//Java中除了8种基本数据类型的变量外，其他变量都是引用类型变量
			//不新建一个对象的话加进去的就是引用，之后对track做的改变还会影响到res中已加进去的元素
			return;
		}
		
		//for选择in选择列表：——>self(wrong)：考虑用iterator迭代，但是在对list等迭代的时候，是不能同时对其进行修改的！会ConcurrentModificationException！
		//	做选择（①将该选择从选择列表中删除②将该选择加入路径）
		//	backtrack（路径，选择列表）
		//	撤销选择（①从路径中删除该选择②将该选择加入选择列表）
		for(int i=0;i<choices.size();i++) {//转换思路：既然不能在迭代选择列表的同时修改选择列表，那就通过设置迭代次数来实现全面覆盖
			//做选择，通过contains避免选到已经包含的
			if(route.contains(choices.get(i))) {
				continue;
			}
			route.add(choices.get(i));
			//backtrack
			backtrack(route,choices);
			//撤销选择（因为这里没有将选择移除选择列表，所以也不用恢复）
			route.remove(choices.get(i));
		}
	}
}

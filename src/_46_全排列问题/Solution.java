package _46_ȫ��������;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public List<List<Integer>> permute(int[] nums){
		LinkedList<Integer> route = new LinkedList<Integer>();//pollLast()�����һ��Ԫ�س��ӣ�add()���һ��Ԫ�ص���β
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
		//��Ϊ��������ᱻ�ݹ���ã�����Ҫ�����ý�������
		//if(��������)��
		//	result.add(·��)
		//	return
		if(route.size()==choices.size()) {
			res.add(new LinkedList(route));//HDPPPPPP!���ﲻ��ֱ��add(route)��������add(new LinkedList(route))����Ϊ��
			//Java�г���8�ֻ����������͵ı����⣬�������������������ͱ���
			//���½�һ������Ļ��ӽ�ȥ�ľ������ã�֮���track���ĸı仹��Ӱ�쵽res���Ѽӽ�ȥ��Ԫ��
			return;
		}
		
		//forѡ��inѡ���б�����>self(wrong)��������iterator�����������ڶ�list�ȵ�����ʱ���ǲ���ͬʱ��������޸ĵģ���ConcurrentModificationException��
		//	��ѡ�񣨢ٽ���ѡ���ѡ���б���ɾ���ڽ���ѡ�����·����
		//	backtrack��·����ѡ���б�
		//	����ѡ�񣨢ٴ�·����ɾ����ѡ��ڽ���ѡ�����ѡ���б�
		for(int i=0;i<choices.size();i++) {//ת��˼·����Ȼ�����ڵ���ѡ���б��ͬʱ�޸�ѡ���б��Ǿ�ͨ�����õ���������ʵ��ȫ�渲��
			//��ѡ��ͨ��contains����ѡ���Ѿ�������
			if(route.contains(choices.get(i))) {
				continue;
			}
			route.add(choices.get(i));
			//backtrack
			backtrack(route,choices);
			//����ѡ����Ϊ����û�н�ѡ���Ƴ�ѡ���б�����Ҳ���ûָ���
			route.remove(choices.get(i));
		}
	}
}

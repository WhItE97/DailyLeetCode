package _322_��Ǯ�һ�;

public class Solution2 {
/**
 * ��̬�滮�ⷨ2�����¶��ϵ�dp�������Ż����Fibonacci��
 * ״̬ת�Ʒ��̣�
 * f(s) = f(s-coin) + 1
 * f(s) = min{traverse coin:f(s-coin)} + 1
 * 
 * ���¶��ϣ�����Ҫһ��forѭ����f(0)��ʼ����dp��
 */
/** ˼·�ܽ᣺
 * 1.�����ٵ�Ӳ�Ҹ���������>��̬�滮���Ž�
 * ��DP���� �ж����ݣ���̬�滮��Ҫ��[�ص������⡢�����ӽṹ��״̬ת�Ʒ���]��
 * 2.��̬�滮�ؼ������㣺
 * ��1��״̬��ԭ������������л�仯�ĵ㡪��>amount
 * ��2��ѡ�񣺵���״̬�仯����Ϊ����>coins
 * ��3����IMP HDP��ȷ��״̬ת�Ʒ��̡���>f(s)=f(s-coin)+1
 * //f(s):���s������Ӳ������coin���������п�ѡ���coins���
 * 3.�Ե����ϼ��㣬�����ظ����㣬����Ч�ʣ�
 * �õ�int[] count = new int[amount+1]//���������ڴ���Ե�������õ��±��Ӧ�Ľ��
 * ����õ�����Ӳ������
 * 4.for(int i=1;i<=amount;i++)
 *     for(int coin:coins)
 * ��һ�������Ե��������ı�����ÿһ�����ֶ�Ҫ���һ����Сֵ������޽�����Ϊ-1����
 * �ڶ���for����ÿһ��amount��Ҫ����һ��coins��ö�٣�ö�ٹ���ע���жϵ�ǰamount
 * �Ƿ��㹻ö�ٸ�coin����>��Ȼ����count[i-coin]��Խ�磡��
 */
	public int coinChange(int[] coins,int amount) {
		if(amount<1) {
			return 0;
		}
		return dp(coins,amount,new int[amount+1]);
	}
	
	public int dp(int[] coins,int amount,int[] count) {
		for(int i=1;i<=amount;i++) {//��f(1)��ʼ�Ե����ϼ���dp
			int min = Integer.MAX_VALUE;
			//��ÿһ��f��Ҫö�����е�coinѡ�񣬲��õ�һ��f(s-coin)
			for(int coin:coins) {
				if((i-coin)<0) {//amount�Ѿ�����������ˣ��������������
					continue;
				}
				//DIFF!!!!�����Ե����ϣ����Կ�����f(amount-coin)��+1�����⣡���f(amount-coin)Ϊ-1����Ҳ�÷���-1
				int res = count[i-coin]>=0?Math.min(min, count[i-coin]+1):-1;//����countȫ��ʼ��Ϊ0��..�жϿ����д�
				if(res>=0&&res<min) {//�������·�ߵ�ͨ����Ӳ����С��min�����滻��
					min = res;
				}
			}
			count[i] = (min==Integer.MAX_VALUE)?-1:min;
		}
		return count[amount];
	}
}

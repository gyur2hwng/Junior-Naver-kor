package gameBoard;

public class text_StopWatch2 extends Thread {
	String timeText;
	long time;
	long preTime;
	boolean play;
	text_StopWatch2() {
		play = true;
	}
	@Override
	public void run() {
		//현재 시간이 초로 변환된 값
		preTime = System.currentTimeMillis();
		while(play)
		{
			try
			{
				sleep(10);
				time = System.currentTimeMillis() - preTime;
				int m = (int)(time / 1000 / 60);
				int s = (int)(time % (1000 * 60) / 1000);
				int ms = (int)(time % 1000 / 10);
				timeText = m + ":" + s + ":" + ms;
				text_stage2_Panel.watchLb.setText(timeText);
				System.out.println(timeText);
			}
			catch (Exception e)
			{
				System.out.println("쓰레드 종료");
			}
		}
	}
}
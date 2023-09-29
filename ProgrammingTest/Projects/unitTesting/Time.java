package unitTesting;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * @author Tyler Snyder Mesures time
 */

public class Time
{
	private int hours;
	private int minutes;
	private int seconds;

	/**
	 * @param hours   takes input from users
	 * @param minutes takes input from users
	 * @param seconds takes input from users
	 */
	public Time(int hours, int minutes, int seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
	 * auto generates variables based on the system clock
	 */
	public Time()
	{
		GregorianCalendar calendar = new GregorianCalendar();
		hours = calendar.get(GregorianCalendar.HOUR);
		minutes = calendar.get(GregorianCalendar.MINUTE);
		seconds = calendar.get(GregorianCalendar.SECOND);
	}

	/**
	 * @return the hours
	 */
	public int getHours()
	{
		return hours;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes()
	{
		return minutes;
	}

	/**
	 * @return the seconds
	 */
	public int getSeconds()
	{
		return seconds;
	}

	public void incrementSeconds()
	{
		fixMinutes();
	}

	private void fixMinutes()
	{
		if (seconds == 59)
		{
			seconds = 0;
			incrementMinutes();
		}
		else
		{
			seconds++;
		}
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(hours, minutes, seconds);
	}

	public void incrementMinutes()
	{
		fixHours();
	}

	private void fixHours()
	{
		if (minutes == 59)
		{
			minutes = 0;
			incrementHours();
		}
		else
		{
			minutes++;
		}
	}

	public void incrementHours()
	{
		if (hours == 23)
		{
			hours = 0;
		}
		else
		{
			hours++;
		}
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hours == other.hours && minutes == other.minutes && seconds == other.seconds;
	}

	@Override
	public String toString()
	{
		return hours + ":" + minutes + ":" + seconds;
	}

}

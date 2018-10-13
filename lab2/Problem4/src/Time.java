public class Time {
    int hour, min, sec;

    public Time(int h, int m, int s) {
        hour = h;
        min = m;
        sec = s;
    }

    public void set(int h, int m, int s) {
        hour = h;
        min = m;
        sec = s;
    }

    public String toUniversal()
    {
        return String.format("%d:%02d:%02d", hour, min, sec);
    }

    public String toStandard()
    {
        return String.format("%d:%02d:%02d ", (hour%12 == 0 ? 12 : hour%12), min, sec) +
                (hour < 12 ? "AM" : "PM");
    }

    public Time add(Time t)
    {
        int s_sum = sec + t.sec;
        int m_sum = min + t.min + s_sum/60;
        int h_sum = hour + t.hour + m_sum/60;
        return new Time((h_sum + 24) % 24, (m_sum + 60) % 60, (s_sum + 60) % 60);
    }
};

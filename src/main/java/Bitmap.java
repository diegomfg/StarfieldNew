import java.util.Arrays;

public class Bitmap {
    private final int m_width;
    private final int m_height;
    private final byte m_components[];

    /**
     * Initializes the Bitmap
     * @param m_width
     * @param m_height
     */

    public Bitmap(int m_width, int m_height) {
        this.m_width = m_width;
        this.m_height = m_height;
        this.m_components = new byte[m_width*m_height*4];
    }

    public int GetWidth() {
        return m_width;
    }

    public int GetHeight() {
        return m_height;
    }



    public void Clear(byte shade){
        Arrays.fill(m_components, shade);
    }

    public void DrawPixel(int x, int y, byte a, byte b, byte g, byte r){
        int index =  (x+ y * m_width) * 4;
        this.m_components[index    ] = a;
        this.m_components[index + 1] = b;
        this.m_components[index + 2] = g;
        this.m_components[index + 3] = r;
    }

    public void CopyToByteArray(byte[] dest){
        for(int i = 0; i < m_height*m_width; i++){
            dest[ i * 3 ]    = m_components[ i * 4 + 1];
            dest[ i * 3 + 1] = m_components[ i * 4 + 2];
            dest[ i * 3 + 2] = m_components[ i * 4 + 3];

        }
    }

}

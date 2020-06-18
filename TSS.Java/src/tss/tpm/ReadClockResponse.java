package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command reads the current TPMS_TIME_INFO structure that contains the current
 *  setting of Time, Clock, resetCount, and restartCount.
 */
public class ReadClockResponse extends TpmStructure
{
    public TPMS_TIME_INFO currentTime;
    
    public ReadClockResponse() {}
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        currentTime.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        currentTime = TPMS_TIME_INFO.fromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static ReadClockResponse fromBytes (byte[] byteBuf) 
    {
        ReadClockResponse ret = new ReadClockResponse();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static ReadClockResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static ReadClockResponse fromTpm (InByteBuf buf) 
    {
        ReadClockResponse ret = new ReadClockResponse();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_ReadClock_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMS_TIME_INFO", "currentTime", currentTime);
    }
}

//<<<

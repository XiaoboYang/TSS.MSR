package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This structure is defined to size the contents of a TPM2B_PRIVATE. This structure is
 *  not directly marshaled or unmarshaled.
 */
public class _PRIVATE extends TpmStructure
{
    public byte[] integrityOuter;
    
    /** Could also be a TPM2B_IV  */
    public byte[] integrityInner;
    
    /** The sensitive area  */
    public TPMT_SENSITIVE sensitive;
    
    public _PRIVATE() {}
    
    /** @param _integrityOuter TBD
     *  @param _integrityInner Could also be a TPM2B_IV
     *  @param _sensitive The sensitive area
     */
    public _PRIVATE(byte[] _integrityOuter, byte[] _integrityInner, TPMT_SENSITIVE _sensitive)
    {
        integrityOuter = _integrityOuter;
        integrityInner = _integrityInner;
        sensitive = _sensitive;
    }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(integrityOuter);
        buf.writeSizedByteBuf(integrityInner);
        buf.writeShort(sensitive != null ? sensitive.toTpm().length : 0);
        if (sensitive != null)
            sensitive.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _integrityOuterSize = buf.readShort() & 0xFFFF;
        integrityOuter = new byte[_integrityOuterSize];
        buf.readArrayOfInts(integrityOuter, 1, _integrityOuterSize);
        int _integrityInnerSize = buf.readShort() & 0xFFFF;
        integrityInner = new byte[_integrityInnerSize];
        buf.readArrayOfInts(integrityInner, 1, _integrityInnerSize);
        int _sensitiveSize = buf.readShort() & 0xFFFF;
        buf.structSize.push(buf.new SizedStructInfo(buf.curPos(), _sensitiveSize));
        sensitive = TPMT_SENSITIVE.fromTpm(buf);
        buf.structSize.pop();
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static _PRIVATE fromBytes (byte[] byteBuf) 
    {
        _PRIVATE ret = new _PRIVATE();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static _PRIVATE fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static _PRIVATE fromTpm (InByteBuf buf) 
    {
        _PRIVATE ret = new _PRIVATE();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("_PRIVATE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "integrityOuter", integrityOuter);
        _p.add(d, "byte", "integrityInner", integrityInner);
        _p.add(d, "TPMT_SENSITIVE", "sensitive", sensitive);
    }
}

//<<<

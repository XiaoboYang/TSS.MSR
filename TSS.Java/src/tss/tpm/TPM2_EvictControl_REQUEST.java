package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command allows certain Transient Objects to be made persistent or a persistent
 *  object to be evicted.
 */
public class TPM2_EvictControl_REQUEST extends TpmStructure
{
    /** TPM_RH_OWNER or TPM_RH_PLATFORM+{PP}
     *  Auth Handle: 1
     *  Auth Role: USER
     */
    public TPM_HANDLE auth;
    
    /** The handle of a loaded object
     *  Auth Index: None
     */
    public TPM_HANDLE objectHandle;
    
    /** If objectHandle is a transient object handle, then this is the persistent handle for
     *  the object
     *  if objectHandle is a persistent object handle, then it shall be the same value as
     *  persistentHandle
     */
    public TPM_HANDLE persistentHandle;
    
    public TPM2_EvictControl_REQUEST()
    {
        auth = new TPM_HANDLE();
        objectHandle = new TPM_HANDLE();
        persistentHandle = new TPM_HANDLE();
    }
    
    /** @param _auth TPM_RH_OWNER or TPM_RH_PLATFORM+{PP}
     *         Auth Handle: 1
     *         Auth Role: USER
     *  @param _objectHandle The handle of a loaded object
     *         Auth Index: None
     *  @param _persistentHandle If objectHandle is a transient object handle, then this is the
     *         persistent handle for the object
     *         if objectHandle is a persistent object handle, then it shall be the same value as
     *         persistentHandle
     */
    public TPM2_EvictControl_REQUEST(TPM_HANDLE _auth, TPM_HANDLE _objectHandle, TPM_HANDLE _persistentHandle)
    {
        auth = _auth;
        objectHandle = _objectHandle;
        persistentHandle = _persistentHandle;
    }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        persistentHandle.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        persistentHandle = TPM_HANDLE.fromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_EvictControl_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_EvictControl_REQUEST ret = new TPM2_EvictControl_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_EvictControl_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_EvictControl_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_EvictControl_REQUEST ret = new TPM2_EvictControl_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_EvictControl_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "auth", auth);
        _p.add(d, "TPM_HANDLE", "objectHandle", objectHandle);
        _p.add(d, "TPM_HANDLE", "persistentHandle", persistentHandle);
    }
}

//<<<

package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command is used to increment the value in an NV Index that has the TPM_NT_COUNTER
 *  attribute. The data value of the NV Index is incremented by one.
 */
public class TPM2_NV_Increment_REQUEST extends TpmStructure
{
    /** Handle indicating the source of the authorization value
     *  Auth Index: 1
     *  Auth Role: USER
     */
    public TPM_HANDLE authHandle;
    
    /** The NV Index to increment
     *  Auth Index: None
     */
    public TPM_HANDLE nvIndex;
    
    public TPM2_NV_Increment_REQUEST()
    {
        authHandle = new TPM_HANDLE();
        nvIndex = new TPM_HANDLE();
    }
    
    /** @param _authHandle Handle indicating the source of the authorization value
     *         Auth Index: 1
     *         Auth Role: USER
     *  @param _nvIndex The NV Index to increment
     *         Auth Index: None
     */
    public TPM2_NV_Increment_REQUEST(TPM_HANDLE _authHandle, TPM_HANDLE _nvIndex)
    {
        authHandle = _authHandle;
        nvIndex = _nvIndex;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_NV_Increment_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "authHandle", authHandle);
        _p.add(d, "TPM_HANDLE", "nvIndex", nvIndex);
    }
}

//<<<

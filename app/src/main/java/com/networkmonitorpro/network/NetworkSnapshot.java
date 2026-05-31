package com.networkmonitorpro.network;
public class NetworkSnapshot { public final String type, carrier, simStatus; public final int signalLevel, qualityScore; public final long downBps, upBps; public final boolean reachable;
 public NetworkSnapshot(String type,String carrier,String simStatus,int signalLevel,long downBps,long upBps,boolean reachable,int qualityScore){this.type=type;this.carrier=carrier;this.simStatus=simStatus;this.signalLevel=signalLevel;this.downBps=downBps;this.upBps=upBps;this.reachable=reachable;this.qualityScore=qualityScore;}
 public boolean is5g(){return type.startsWith("5G");}
}

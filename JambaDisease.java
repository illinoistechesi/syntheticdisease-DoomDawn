
class JambaDisease extends DiseaseBlueprint {
    
    @Override
    public String getName() {
        return "JambaDisease";
    }
    
    @Override
    public double getInfectivity(AgeGroup ageGroup) {
        return 0;
    }
    
    @Override
    public double getToxigenicity(AgeGroup ageGroup) {
        return 0;
    }
    
    @Override
    public double getResistance(AgeGroup ageGroup) {
        return 0;
    }
    
    private int lastEnergy = 0;
    private int ReleaseCount = 0;
    private int ExitCount = 0;
    private int MultiplyCount = 0;
    
    @Override
    public DiseaseAction move(SimulatedHost host) {
        DiseaseAction action = DiseaseAction.MULTIPLY;
        if(host.isIncubated()){
            int energyLoss = lastEnergy - host.getEnergy();
            if(energyLoss > host.getEnergy()){
                action = DiseaseAction.MULTIPLY;
                MultiplyCount ++;
            }
            else{
                int days = host.getDaysSinceInfection();
                if(days % 2 == 0){
                    action = DiseaseAction.RELEASE;
                    ReleaseCount ++;
                }
                else{
                    action = DiseaseAction.EXIT;
                    ExitCount ++;
                }
            }
        }
        else{
            action = DiseaseAction.MULTIPLY;
        }
        lastEnergy = host.getEnergy();
        return action;
    }
    
}
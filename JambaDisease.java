
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
    
    @Override
    public DiseaseAction move(SimulatedHost host) {
        DiseaseAction action = DiseaseAction.MULTIPLY;
        return action;
    }
    
}
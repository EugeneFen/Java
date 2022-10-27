public class Horse {
        private String name;
        private int weight;
        Horse()
        {
                name = "-";
                weight = 0;
        }
        String getName()
        {
                return name;
        }
        int getWeight()
        {
                return weight;
        }
        void setName(String name)
        {
                this.name = name;
        }
        void setWeight(int weight)
        {
                this.weight = weight;
        }
}

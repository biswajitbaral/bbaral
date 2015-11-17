package gearman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;

public class NewVM
{

    /**
     * @param args
     */
    public static void startGearmanInstance(Class<? extends Object> clazz, boolean redirectStream) throws Exception
    {
        System.out.println(clazz.getCanonicalName());
        String separator = System.getProperty("file.separator");
        String classpath = System.getProperty("java.class.path");
        System.out.println(System.getProperty("name"));

        String path = System.getProperty("java.home") + separator + "bin" + separator + "java";
        ProcessBuilder processBuilder = new ProcessBuilder(path, "-Dpid=$$", "-cp", classpath, clazz.getCanonicalName());

        processBuilder.redirectErrorStream(redirectStream);

        Process process = processBuilder.start();

        System.out.println(ManagementFactory.getRuntimeMXBean().getName());

        System.out.println(getPid(process));
        // process.waitFor();
        // process.destroy();
        // printTrace(process);

        System.out.println("Finished.");
    }

    public static void printTrace(Process p)
    {
        StringBuffer output = new StringBuffer();
        InputStreamReader inputStream = null;
        BufferedReader br = null;
        try
        {

            inputStream = new InputStreamReader(p.getInputStream());
            br = new BufferedReader(inputStream);
            String line = "";

            while ((line = br.readLine()) != null)
            {
                output.append(line + "\n");
            }
            System.out.println(output);
        }

        catch (IOException e)
        {
            System.out.println("Error!!!!!!!!!!!!!!!");

        }
        finally
        {
            if (inputStream != null)
            {
                try
                {
                    inputStream.close();
                }
                catch (IOException e)
                {

                }
            }
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {

                }

            }

        }
    }

    public static long getPid(Process process)
    {
        if (process.getClass().getName().equals("java.lang.UNIXProcess"))
        {
            int pid;
            try
            {
                Field f = process.getClass().getDeclaredField("pid");
                f.setAccessible(true);
                pid = f.getInt(process);
                return pid;
            }
            catch (Throwable e)
            {

            }
        }
        /*
         * if (process.getClass().getName().equals("java.lang.Win32Process") ||
         * process.getClass().getName().equals("java.lang.ProcessImpl")) {
         * 
         * try { Field f = process.getClass().getDeclaredField("handle"); f.setAccessible(true); long handl =
         * f.getLong(process);
         * 
         * Kernel32 kernel = Kernel32.INSTANCE; W32API.HANDLE handle = new W32API.HANDLE();
         * handle.setPointer(Pointer.createConstant(handl)); pid = kernel.GetProcessId(handle); } catch (Throwable e) {
         * } }
         */
        return -1;
    }

    public static void main(String[] args)
    {
        try
        {
            startGearmanInstance(EchoWorkerServer.class, true);
            System.out.println("main");
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Exit");
    }

}

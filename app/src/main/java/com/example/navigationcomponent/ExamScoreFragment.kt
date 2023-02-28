package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentExamScoreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExamScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExamScoreFragment : Fragment() {
    lateinit var binding: FragmentExamScoreBinding
    val args: ExamScoreFragmentArgs by navArgs()
    val midtermExamPercentage = 0.4
    val finalExamPercentage = 0.6
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentExamScoreBinding.inflate(inflater, container, false)

        val courseName = args.exam.courseName
        val midtermExamScore = args.exam.midtermExamScore
        val finalExamScore = args.exam.finalExamScore
        val averageExamScore = calculateAverageScore(midtermExamScore, finalExamScore)

        binding.textViewCourseName.text = "$courseName Course Name Scores"
        binding.textViewMidtermExamScore.text = "Midterm Exam Score: $midtermExamScore"
        binding.textViewFinalExamScore.text = "Final Exam Score: $finalExamScore"
        binding.textViewAverageExamScore.text = "Average Score: $averageExamScore"

        return binding.root
    }

    private fun calculateAverageScore(midtermExamScore: Double, finalExamScore: Double): Any {
        return (midtermExamScore * midtermExamPercentage) + (finalExamScore * finalExamPercentage)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExamScoreFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExamScoreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}